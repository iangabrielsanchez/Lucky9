public class MakeStatic{
    public static final boolean SIMPLE = true;
    public static final boolean CANONICAL = false;
    public static class ClassGetter extends SecurityManager {
        public String getClassName(boolean isSimple) {
            if(CANONICAL){
                    return getClassContext()[1].getName();
            }
            else{
                    return getClassContext()[1].getSimpleName();
            }
        }
    }
}