package com.plusmilesdev.tngapi.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SampleUtils {

	public static String getRandomName() {
		String firstnames[]= {"Mohamad", "Abdullah", "Ahmad", "Siti", "Nur", "Sofea"};
		String lastnames[]= {"Ridzwan", "Amin", "Hasanah", "Fatah", "Ifwat", "Omar"};
		return firstnames[new Random().nextInt(firstnames.length)]+" "+lastnames[new Random().nextInt(lastnames.length)];
	}

}
