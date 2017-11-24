package cn.mylava.Tmp.test;

/**
 * @author lipengfei
 */
public class SignConf {
    private String secrect;
    private String params;
    private String encryp;
    private String sort;
    private String caseStr;

    public String getSecrect() {
        return secrect;
    }

    public void setSecrect(String secrect) {
        this.secrect = secrect;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getEncryp() {
        return encryp;
    }

    public void setEncryp(String encryp) {
        this.encryp = encryp;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCaseStr() {
        return caseStr;
    }

    public void setCaseStr(String caseStr) {
        this.caseStr = caseStr;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SignConf{");
        sb.append("secrect='").append(secrect).append('\'');
        sb.append(", params='").append(params).append('\'');
        sb.append(", encryp='").append(encryp).append('\'');
        sb.append(", sort='").append(sort).append('\'');
        sb.append(", caseStr='").append(caseStr).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
