package clientname.gui.options;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import clientname.gui.hud.HUDManager;
import clientname.gui.hud.IRenderer;
import clientname.gui.options.*;
import clientname.mods.Mod;
import net.minecraft.client.Minecraft;

import net.minecraft.client.gui.GuiListExtended;



public class ScrollListModToggle extends GuiListExtended {
	
	private static int fadeIn;
	private boolean fadingOut;
	private static int fadeOut;
	
	

	private final List<ModEntry> entrys = new ArrayList<ModEntry>();
	
	
	public void initGui() {
		this.fadeIn = 0;
		this.fadingOut = false;
		this.fadeOut = 0;
	}
	

	public void updateScreen() {
if(fadeIn < 200) {
		fadeIn++;
	}
	
	
	
	
	if(fadingOut) {
		if(fadeOut < 200) {
		fadeOut++;	
		}
	}
		
		
		
	}

	public ScrollListModToggle(Minecraft mcIn, GuiModToggle inGui) {
		super(mcIn, inGui.width, inGui.height, inGui.width, inGui.height, 20);
		for(IRenderer r : HUDManager.getInstance().getRegisteredRenderers()) {
			if(r instanceof Mod) {
				Mod m = (Mod)r;
				entrys.add(new ModEntry(inGui, m));
			}
		}
		 Collections.sort(this.entrys); 
	}

	

	@Override
	public IGuiListEntry getListEntry(int index) {
		return entrys.get(index);
	}

	@Override
	protected int getSize() {
		return entrys.size();
	}

}