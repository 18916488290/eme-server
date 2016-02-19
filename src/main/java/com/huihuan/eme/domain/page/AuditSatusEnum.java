package com.huihuan.eme.domain.page;

public enum AuditSatusEnum {
	
	NotAudit("未审核",0l),Yes("审核通过",1l),No("审核拒绝",2l);
	
	
	private String name;
    private long index;

    // 构造方法
    private AuditSatusEnum(String name, long index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(long index) {
        for (AuditSatusEnum a : AuditSatusEnum.values()) {
            if (a.getIndex() == index) {
                return a.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

}
