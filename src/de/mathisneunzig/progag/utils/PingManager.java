package de.mathisneunzig.progag.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.entity.Player;

public class PingManager {
	
	public int getPing(Player player) {
		try {
			Object nms_player = player.getClass().getMethod("getHandle").invoke(player);
			Field fieldPing = nms_player.getClass().getDeclaredField("ping");
			fieldPing.setAccessible(true);
			return fieldPing.getInt(nms_player);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
}
