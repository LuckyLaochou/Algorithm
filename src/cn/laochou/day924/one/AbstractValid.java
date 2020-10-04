package cn.laochou.day924.one;

public abstract class AbstractValid {
    protected String condition;
    public AbstractValid(String condition) {
        this.condition = condition;
    }
    protected AbstractValid nextValid;
    public void setNextValid(AbstractValid valid) {
        this.nextValid = valid;
    }
    public boolean valid() {
        if(condition()) {
            if(nextValid != null) {
                return nextValid.valid();
            }
            return true;
        }
        return false;
    }
    public abstract boolean condition();
}
