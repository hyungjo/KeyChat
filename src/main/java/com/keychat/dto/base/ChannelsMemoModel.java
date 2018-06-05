package com.keychat.dto.base;

import java.io.Serializable;

public class ChannelsMemoModel implements Serializable {
	private int channels_memo_id;
	private String email;
	private String contents;

	public ChannelsMemoModel() {
		super();
	}

	public ChannelsMemoModel(int channels_memo_id, String email, String contents) {
		super();
		this.channels_memo_id = channels_memo_id;
		this.email = email;
		this.contents = contents;
	}

	public int getChannels_memo_id() {
		return channels_memo_id;
	}

	public void setChannels_memo_id(int channels_memo_id) {
		this.channels_memo_id = channels_memo_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "channels_memo_dto [channels_memo_id=" + channels_memo_id + ", email=" + email + ", contents=" + contents
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + channels_memo_id;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		ChannelsMemoModel other = (ChannelsMemoModel) obj;
		if (channels_memo_id != other.channels_memo_id)
			return false;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
}