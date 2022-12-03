package com.hq.pojo;

import lombok.Data;

@Data
public class Cooker {
	private int userId;
	private String userAccount;
	private String userPass;
	private int role;
	private int locked;
	private String faceimg;
}
