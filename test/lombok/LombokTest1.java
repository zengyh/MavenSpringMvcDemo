package lombok;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-8-19 上午10:17:00
 * @文件描述: 这个类提示报错，是因为项目使用Lombok.jar（插件）在编译时，
 *           往User类注入了Getter和Setter方法，编译、打包和运行都是没问题的。
 *           但是由于IDE平台没有安装Lombok插件，所以在IDE上会提示报“No Such Method”的错误，
 *           安装了该插件就没问题了。
 *           
 */
public class LombokTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        User user = new User();
        user.setUserName("aa225");
        System.out.println(user.getUserName());
	}

}
