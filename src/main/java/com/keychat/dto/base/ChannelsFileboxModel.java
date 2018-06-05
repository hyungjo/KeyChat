package com.keychat.dto.base;

import java.io.Serializable;
public class ChannelsFileboxModel implements Serializable {
	private int channels_file_id;
	private String email;
	private String file_path;
	private String channel_name;

	public ChannelsFileboxModel() {
		super();
	}

	public ChannelsFileboxModel(int channels_file_id, String email, String file_path, String channel_name) {
		super();
		this.channels_file_id = channels_file_id;
		this.email = email;
		this.file_path = file_path;
		this.channel_name = channel_name;
	}

	public int getChannels_file_id() {
		return channels_file_id;
	}

	public void setChannels_file_id(int channels_file_id) {
		this.channels_file_id = channels_file_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	@Override
	public String toString() {
		return "channels_filebox_dto [channels_file_id=" + channels_file_id + ", email=" + email + ", file_path="
				+ file_path + ", channel_name=" + channel_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		result = prime * result + channels_file_id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((file_path == null) ? 0 : file_path.hashCode());
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
		ChannelsFileboxModel other = (ChannelsFileboxModel) obj;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		if (channels_file_id != other.channels_file_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (file_path == null) {
			if (other.file_path != null)
				return false;
		} else if (!file_path.equals(other.file_path))
			return false;
		return true;
	}
}