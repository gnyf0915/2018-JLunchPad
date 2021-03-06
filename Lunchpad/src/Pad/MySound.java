package Pad;

import java.io.*;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MySound{
	public static ArrayList<String> SoundList = new ArrayList<String>();
	
	public void playMusic(String adress) {
		playSound("Audio/(" + adress + ").wav");
	}
	
	public void playSound(String adress) {
	    try {
	        AudioInputStream audio = AudioSystem.getAudioInputStream(new File(adress).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audio);
	        clip.start();
	    } 
	    catch(Exception e) {
	        System.out.println("Error with playing sound.");
	        e.printStackTrace();
	    }
	}
	
	public void SaveSound(String adress) {
		System.out.println(adress);
		SoundList.add(adress);
	}
	
	public void RemoveSound() {
		SoundList.clear();
	}
	
	public void PrintSound() {
		System.out.println(SoundList);
		
		File f = new File("SoundList.txt");
		
		try{
			if(!f.exists()){
				f.createNewFile();
			}
			
			FileWriter fw = new FileWriter(f,true);
			fw.write(SoundList + "\n");
			fw.flush();
			fw.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
