package tag;

import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.mvcdemo.utils.StringUtils;


/**
 * 文件名称: ImagePreviewLinkTag.java
 * 编写人: yh.zeng
 * 编写时间: 15-1-7 下午3:58
 * 文件描述: 鼠标悬停在链接上展示预览图片的Tag，若同时指定预览图片的宽度和高度，则高度无效按照宽度缩放图片
 */
public class ImagePreviewLinkTag extends ImageScaleTag
{
    Logger logger = LoggerFactory.getLogger(ImagePreviewLinkTag.class);

    private String linkId;      //悬停展示预览图片的链接<a>的ID
    private String linkTxt;     //悬停展示预览图片的链接<a>的文本
    private String linkStyle;   //悬停展示预览图片的链接<a>的内联样式
    private String linkClass;   //悬停展示预览图片的链接<a>的class样式
    private String imageId;     //悬停展示的预览图片<image>的ID
    private String imageStyle;  //悬停展示的预览图片<image>的内联样式
    private String imageClass;  //悬停展示的预览图片<image>的class样式
    private String imageSrc;    //悬停展示的预览图片<image>的地址
    private Integer imageWidth;  //指定悬停展示的预览图片<image>的宽度，图片会按照该宽度进行缩放
    private Integer imageHeight; //指定悬停展示的预览图片<image>的高度，图片会按照该高度进行缩放，若是已经只指定了宽度，则高度无效
    private String beforeLinkTxt = ""; //在“悬停展示预览图片的链接<a>”前追加文本信息
    private String afterLinkTxt = ""; //在“悬停展示预览图片的链接<a>”后追加文本信息

    private String onClick;     //悬停展示预览图片的链接<a>的点击事件

    @Override
    public int doStartTag() throws JspException {

        Date date = new Date();

        if(this.imageStyle == null){
            this.imageStyle = "position:absolute;display:none;";
        }else{
            if(this.imageStyle.lastIndexOf(";") == this.imageStyle.length() - 1){
                this.imageStyle =  this.imageStyle + "position:absolute;display:none;";
            }else{
                this.imageStyle =  this.imageStyle + ";position:absolute;display:none;";
            }
        }
        super.setStyle(this.imageStyle);

        try {
            JspWriter jspWriter = this.pageContext.getOut();

            //页面标签
            jspWriter.println("" +
                    "<div style=\"position: relative;float: left;padding: 0\">\n" +
                       getBeforeLinkTxt() +
                       "<a "+getLinkIdTagAttr()+getLinkStyleTagAttr()+getLinkClassTagAttr()+"  href=\"javascript:void(0)\" "+getOnClickTagAttr()+" >"+linkTxt+"</a>\n"
                    );
            super.doStartTag();
            jspWriter.println(getAfterLinkTxt()+"</div>");

            //事件函数
            jspWriter.println("" +
                    "<script type=\"text/javascript\">\n" +
                    "    (function (tLinkObj, imageObj) {\n" +
                    "\n" +
                    "        /**\n" +
                    "         * 追加事件处理\n" +
                    "         * @param e 要添加事件的DOM节点对象\n" +
                    "         * @param eventType 事件类型，如\"click\"\n" +
                    "         * @param callbackFunc 事件触发的方法\n" +
                    "         */\n" +
                    "        function addEvent"+date.getTime()+"(e, eventType, callbackFunc) {\n" +
                    "\n" +
                    "            if (e.addEventListener) {   //非ie 和ie9\n" +
                    "                e.addEventListener(eventType, callbackFunc, false);\n" +
                    "\n" +
                    "            } else if (e.attachEvent) {  //ie6到ie8\n" +
                    "                e.attachEvent(\"on\" + eventType, function(){\n" +
                    "                      callbackFunc.apply(e, arguments);  //让func函数里面的this指向e\n" +
                    "                });\n" +
                    "            } else {     //ie5\n" +
                    "                e[\"on\" + eventType] = callbackFunc;\n" +
                    "            }\n" +
                    "\n" +
                    "        }\n" +
                    "\n" +
                    "        //鼠标移入事件\n" +
                    "        function tLinkObjMouseEnterEvent"+date.getTime()+"(e) {\n" +
                    "            e = e || window.event;\n" +
                    "\n" +
                    "            var left = e.x || e.pageX || 0;\n" +
                    "            var top = e.y || e.pageY || 0;\n" +
                    "            left += 3;\n" +
                    "            top += 3;\n" +
                    "            if (imageObj.offsetWidth + left > document.body.offsetWidth) {\n" +
                    "                left = document.body.offsetWidth - imageObj.offsetWidth - 10;\n" +
                    "                left = left < 0 ? 0 : left;\n" +
                    "            }\n" +
                    "            if (imageObj.offsetHeight + top > document.body.offsetHeight) {\n" +
                    "                top = document.body.offsetHeight - imageObj.offsetHeight - 10;\n" +
                    "                top = top < 0 ? 0 : top;\n" +
                    "            }\n" +
                    "            imageObj.style.left = left + \"px\";\n" +
                    "            //imageObj.style.top = top + \"px\"; //图片跟随鼠标的位置显示\n" +
                    "            imageObj.style.top = tLinkObj.offsetHeight + \"px\"; //图片显示在文字底部下面\n" +
                    "\n" +
                    "            imageObj.style.display = \"block\";\n" +
                    "\n" +
                    "\n" +
                    "            //阻止浏览器的默认事件行为\n" +
                    "            if (e && e.preventDefault) {//如果是FF下执行这个\n" +
                    "                e.preventDefault();\n" +
                    "            } else {\n" +
                    "                window.event.returnValue = false;//如果是IE下执行这个\n" +
                    "            }\n" +
                    "\n" +
                    "        }\n" +
                    "\n" +
                    "        //鼠标在链接上移动事件\n" +
                    "        function tLinkObjMouseMoveEvent"+date.getTime()+"(e) {\n" +
                    "            e = e || window.event;\n" +
                    "\n" +
                    "            var left = e.x || e.pageX || 0;\n" +
                    "            var top = e.y || e.pageY || 0;\n" +
                    "            left += 3;\n" +
                    "            top += 3;\n" +
                    "            if (imageObj.offsetWidth + left > document.body.offsetWidth) {\n" +
                    "                left = document.body.offsetWidth - imageObj.offsetWidth - 10;\n" +
                    "                left = left < 0 ? 0 : left;\n" +
                    "            }\n" +
                    "            if (imageObj.offsetHeight + top > document.body.offsetHeight) {\n" +
                    "                top = document.body.offsetHeight - imageObj.offsetHeight - 10;\n" +
                    "                top = top < 0 ? 0 : top;\n" +
                    "            }\n" +
                    "            imageObj.style.left = left + \"px\";\n" +
                    "            //imageObj.style.top = top + \"px\";  //图片跟随鼠标的位置显示\n" +
                    "            imageObj.style.top = tLinkObj.offsetHeight + \"px\"; //图片显示在文字底部下面\n" +
                    "\n" +
                    "            imageObj.style.display = \"block\";\n" +
                    "\n" +
                    "\n" +
                    "            //阻止浏览器的默认事件行为\n" +
                    "            if (e && e.preventDefault) {//如果是FF下执行这个\n" +
                    "                e.preventDefault();\n" +
                    "            } else {\n" +
                    "                window.event.returnValue = false;//如果是IE下执行这个\n" +
                    "            }\n" +
                    "        }\n" +
                    "\n" +
                    "\n" +
                    "        //鼠标从悬停移出事件\n" +
                    "        function tLinkObjMouseOutEvent"+date.getTime()+"(e) {\n" +
                    "            e = e || window.event;\n" +
                    "\n" +
                    "            imageObj.style.display = \"none\";\n" +
                    "\n" +
                    "            //阻止浏览器的默认事件行为\n" +
                    "            if (e && e.preventDefault) {//如果是FF下执行这个\n" +
                    "                e.preventDefault();\n" +
                    "            } else {\n" +
                    "                window.event.returnValue = false;//如果是IE下执行这个\n" +
                    "            }\n" +
                    "        }\n" +
                    "\n" +
                    "        addEvent"+date.getTime()+"(tLinkObj, \"mouseenter\", tLinkObjMouseEnterEvent"+date.getTime()+");\n" +
                    "        addEvent"+date.getTime()+"(tLinkObj, \"mouseout\", tLinkObjMouseOutEvent"+date.getTime()+");\n" +
                    "        addEvent"+date.getTime()+"(tLinkObj, \"mousemove\", tLinkObjMouseMoveEvent"+date.getTime()+");\n" +
                    "\n" +
                    "    })(document.getElementById(\""+linkId+"\"), document.getElementById(\""+imageId+"\"));\n" +
                    "</script>");


        } catch (IOException e) {
            logger.error(StringUtils.getExceptionMessage(e));
        }

        return BodyTagSupport.SKIP_BODY;
    }


    private String getOnClickTagAttr(){
        if(onClick == null){
            return "";
        }else{
            return "onclick=\""+onClick+"\" ";
        }
    }

    private String getLinkIdTagAttr(){
        if(linkId == null){
            return "id=\"tLink\" ";
        }else{
            return "id=\""+linkId+"\" ";
        }
    }

    private String getLinkStyleTagAttr(){
        if(linkStyle == null){
            return "";
        }else{
            return "style=\""+linkStyle+"\" ";
        }
    }

    private String getLinkClassTagAttr(){
        if(linkClass == null){
            return "";
        }else{
            return "class=\""+linkClass+"\" ";
        }
    }

    @Override
    public int doEndTag() throws JspException {
        return BodyTagSupport.EVAL_PAGE;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkTxt() {
        return linkTxt;
    }

    public void setLinkTxt(String linkTxt) {
        this.linkTxt = linkTxt;
    }

    public String getLinkStyle() {
        return linkStyle;
    }

    public void setLinkStyle(String linkStyle) {
        this.linkStyle = linkStyle;
    }

    public String getLinkClass() {
        return linkClass;
    }

    public void setLinkClass(String linkClass) {
        this.linkClass = linkClass;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
        super.setId(imageId);
    }

    public String getImageStyle() {
        return imageStyle;
    }

    public void setImageStyle(String imageStyle) {
        this.imageStyle = imageStyle;
    }

    public String getImageClass() {
        return imageClass;
    }

    public void setImageClass(String imageClass) {
        this.imageClass = imageClass;
        super.setStyleClass(imageClass);
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
        super.setSrc(imageSrc);
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
        super.setWidth(imageWidth);
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
        super.setHeight(imageHeight);
    }

    public String getOnClick() {
        return onClick;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    public String getBeforeLinkTxt() {
        return beforeLinkTxt;
    }

    public void setBeforeLinkTxt(String beforeLinkTxt) {
        this.beforeLinkTxt = beforeLinkTxt;
    }

    public String getAfterLinkTxt() {
        return afterLinkTxt;
    }

    public void setAfterLinkTxt(String afterLinkTxt) {
        this.afterLinkTxt = afterLinkTxt;
    }
}
