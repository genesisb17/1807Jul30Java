package com.ex.servicepackage;

import java.util.List;
import java.util.Scanner;

import com.ex.dao.JunctionDAO;
import com.ex.pojo.Client_Account_Junction;

public class JunctionService {
	
	static JunctionDAO jdao = new JunctionDAO();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		List<Client_Account_Junction> j = jdao.findAll();
		for(Client_Account_Junction k: j) {
			System.out.println(k);
		}
	}
}
