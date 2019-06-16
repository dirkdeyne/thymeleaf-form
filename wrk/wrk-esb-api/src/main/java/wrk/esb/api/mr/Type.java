package wrk.esb.api.mr;

public enum Type {
  PC("PWS"),LAPTOP("LAP"),SERVER("SRV");
  private String code;
  Type(String code){
    this.code = code;
  }
 
  public String getCode() {
        return code;
    }
}
