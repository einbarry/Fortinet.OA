package OA;

public class Singleton {
	
	private Singleton(){}
	
	private static class SingletonHolder {
		static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
