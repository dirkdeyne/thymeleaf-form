package wrk.esb.api.mr;

public enum Os {
  WINDOWS("WIN"), LINUX("LNX"), MACOS("MCS");
  private String code;
  Os(String code){
    this.code = code;
  }
 
  public String getCode() {
		return code;
	}
}
