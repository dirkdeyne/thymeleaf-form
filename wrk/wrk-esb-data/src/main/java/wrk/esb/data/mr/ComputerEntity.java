package wrk.esb.data.mr;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import wrk.esb.api.mr.Computer;
import wrk.esb.api.mr.Os;
import wrk.esb.api.mr.Type;

@Entity
@Table(name = "T_COMPUTER")
public class ComputerEntity implements Computer {

	@Id
	String serial;

	@Enumerated(EnumType.STRING)
	private Type type;

	@Enumerated(EnumType.STRING)
	private Os os;

	public ComputerEntity() {
	}

	public ComputerEntity(Type type, Os os) {
		serial = String.format("%s%s%s", type.getCode(), os.getCode(), UUID.randomUUID().toString().substring(0, 8).toUpperCase());
		this.type = type;
		this.os = os;
	}

	@Override
	public String getSerial() {
		return serial;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public Os getOs() {
		return os;
	}

	@Override
	public String toString() {
		return String.format("%s %s [serial=%s]", os, type, serial);
	}
}
