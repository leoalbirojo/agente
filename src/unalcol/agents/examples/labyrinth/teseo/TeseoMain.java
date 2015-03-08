package unalcol.agents.examples.labyrinth.teseo;
import unalcol.agents.Agent;

import unalcol.agents.examples.labyrinth.*;
import unalcol.agents.examples.labyrinth.teseo.simple.RandomReflexTeseo;
import unalcol.agents.examples.labyrinth.teseo.code47.Code47;
import unalcol.agents.examples.labyrinth.teseo.code46.Code46;
import unalcol.agents.examples.labyrinth.teseo.agente47.Agente47;
import unalcol.agents.simulate.util.*;

public class TeseoMain {
  private static SimpleLanguage getLanguage(){
    return  new SimpleLanguage( new String[]{"front", "right", "back", "left", "exit",
        "afront", "aright", "aback", "aleft"},
                                   new String[]{"no_op", "die", "advance", "rotate"}
                                   );
  }

  public static void main( String[] argv ){
    //  InteractiveAgentProgram p = new InteractiveAgentProgram( getLanguage() );
//    TeseoSimple p = new TeseoSimple();
    //Code46 p=new Code46();
    Code47 p=new Code47();
    //Agente47 p=new Agente47();
    //RandomReflexTeseo p = new RandomReflexTeseo();
    p.setLanguage(getLanguage());
    LabyrinthDrawer.DRAW_AREA_SIZE = 600;
    LabyrinthDrawer.CELL_SIZE = 40;
    Labyrinth.DEFAULT_SIZE = 15;
    Agent agent = new Agent( p );
    TeseoMainFrame frame = new TeseoMainFrame( agent, getLanguage() );
    frame.setVisible(true); 
  }
}
