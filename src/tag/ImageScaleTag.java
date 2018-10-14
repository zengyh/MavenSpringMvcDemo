package tag;

import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.utils.StringUtils;

/**
 * 文件名称: ImageScaleTag.java
 * 编写人: yh.zeng
 * 编写时间: 15-1-7 下午1:30
 * 文件描述: 缩放显示图片，按照指定的宽度或则指定的高度来缩放图片，若同时指定宽度和高度，则高度无效按照宽度缩放图片
 */
public class ImageScaleTag extends BodyTagSupport
{
    Logger logger = LoggerFactory.getLogger(ImageScaleTag.class);

    private String id;          //图片的ID
    private String styleClass;  //图片的样式类Class
    private String style;       //图片的内联样式
    private String src;         //图片地址
    private Integer width;      //宽度，指定展示的图片的宽度
    private Integer height;     //高度，指定展示的图片的高度


    @Override
    public int doStartTag() throws JspException {

        JspWriter jspWriter  = this.pageContext.getOut();
        try {
            Date date = new Date();

            //事件函数
            jspWriter.println("<script type=\"text/javascript\">\n" +
                    "   /**\n" +
                    "    * 通过制定的高度缩放图片\n" +
                    "    * @param imageObj  要缩放的图片对象\n" +
                    "    * @param height    指定的图片高度\n" +
                    "    */\n" +
                    "   function scaleImageByHeight"+date.getTime()+"(imageObj, height){\n" +
                    "       var img = new Image();\n" +
                    "       img.src = imageObj.src;\n" +
                    "       imageObj.width = img.width*height/img.height;  //这里的img.width和img.height为原图大小\n" +
                    "       imageObj.height = height;\n" +
                    "   }\n" +
                    "   /**\n" +
                    "    * 通过制定的宽度缩放图片\n" +
                    "    * @param imageObj  要缩放的图片对象\n" +
                    "    * @param width     指定的图片宽度\n" +
                    "    */\n" +
                    "   function scaleImageByWidth"+date.getTime()+"(imageObj, width){\n" +
                    "       var img = new Image();\n" +
                    "       img.src = imageObj.src;\n" +
                    "       imageObj.height = img.height*width/img.width;  //这里的img.width和img.height为原图大小\n" +
                    "       imageObj.width = width;\n" +
                    "   }\n" +
                    "</script>");

            //页面标签
            if(width != null){   //按指定宽度缩放展示图片
                jspWriter.println("<img "+getTagIdAttr()+getTagClassAttr()+getTagStyleAttr()+" src=\"" + src + "\" width=\"0\" height=\"0\" onload=\"scaleImageByWidth"+date.getTime()+"(this, " + width + ")\">");
            }else if(height != null){  //按指定高度缩放展示图片
                jspWriter.println("<img "+getTagIdAttr()+getTagClassAttr()+getTagStyleAttr()+" src=\"" + src + "\" width=\"0\" height=\"0\" onload=\"scaleImageByHeight"+date.getTime()+"(this, " + height + ")\">");
            }else{           //按原图大小展示图片
                jspWriter.println("<img "+getTagIdAttr()+getTagClassAttr()+getTagStyleAttr()+" src=\"" + src + "\">");
            }

        } catch (IOException e) {
            logger.error(StringUtils.getExceptionMessage(e));
        }

        return BodyTagSupport.SKIP_BODY;
    }


    @Override
    public int doEndTag() throws JspException {
        return BodyTagSupport.EVAL_PAGE;
    }

    /**
     * 获取标签的class属性值对
     * @return
     */
    private String getTagClassAttr(){
       if(styleClass != null){
           return "class=\"" + styleClass + "\" ";
       }else{
           return "";
       }
    }

    /**
     * 获取标签的id属性值对
     * @return
     */
    private String getTagIdAttr(){
       if(id != null){
           return "id=\"" + id + "\" ";
       }else{
           return "";
       }
    }

    /**
     * 获取标签的style样式属性值对
     * @return
     */
    private String getTagStyleAttr(){
       if(style != null){
           return "style=\"" + style + "\" ";
       }else{
           return "";
       }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
