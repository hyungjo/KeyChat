package com.keychat.dto.base;

import java.io.Serializable;

public class UsersJoinChannelsJoinModel  implements Serializable{
	private String email;
	private String channel_name;
	private String nicname;
	public UsersJoinChannelsJoinModel() {
		super();
	}
	public UsersJoinChannelsJoinModel(String email, String channel_name, String nicname) {
		super();
		this.email = email;
		this.channel_name = channel_name;
		this.nicname = nicname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public String getNicname() {
		return nicname;
	}
	public void setNicname(String nicname) {
		this.nicname = nicname;
	}
	@Override
	public String toString() {
		return "UsersJoinChannelsJoinDto [email=" + email + ", channel_name=" + channel_name + ", nicname=" + nicname
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nicname == null) ? 0 : nicname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersJoinChannelsJoinModel other = (UsersJoinChannelsJoinModel) obj;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nicname == null) {
			if (other.nicname != null)
				return false;
		} else if (!nicname.equals(other.nicname))
			return false;
		return true;
	}
}
