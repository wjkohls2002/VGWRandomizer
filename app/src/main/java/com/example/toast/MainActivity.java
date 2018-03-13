package com.example.toast.vgwrandomizer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import java.util.Arrays;
import static com.example.toast.vgwrandomizer.Cards.*;

public class MainActivity extends AppCompatActivity {
    //LISTENERS:
    buttonMain buttonListener = new buttonMain();
    buttonRandomPage bRPL = new buttonRandomPage();
    buttonSettings SPBL = new buttonSettings();
    SeekBarListen sbl = new SeekBarListen();

    //SPINNERS:
    Spinner spinner;

    //BUTTONS:
    Button randomize, restart, reRandomize, HELP;
    ImageButton settings;

    //TEXT VIEWS:
    TextView modeText, SmartnessText, PlayersText;

    //SEEK BARS:
    SeekBar SMARTNESS, PLAYERS, HowManyBuild, HowManyDS, HowManySpells, HowManyUnits;

    //CHECKBOXES:
    CheckBox SpellsNotDefence;

    //CARD ARRAYS:
    Card[] buildings = new Card[6];
    Card[] Units = new Card[3];
    Card[] defences = new Card[3];
    Card[] allCards;

    //SHORTS:
    short NumOfBuild = 6;
    short NumOfDS = 3;
    short NumOfUnits = 3;
    short NumOfSpells = 3;
    short SMARTNESSint = 0;
    short NUmOfPlayersMax = 4;
    short smartness = 0;

    //BOOLEAN:
    boolean Random = false;
    boolean AlwaysUse = false;
    boolean useSpells = true;
    boolean UseSpellsBefore = true;
    boolean firstTime = true;

    //BOOLEAN ARRAYS:
    boolean[] ownedExpansions = {true, false, false, false, false, false};

    //STRINGS:
    String CurrentScreen = "MAIN";
    String clicked = "";

    //OTHERS:
    ArrayAdapter<CharSequence> adapter;
    SharedPreferences savedData;
    //-----{onCreate}---------------------------------------------------------------------------------
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allCards = Cards.composeDecks();
        savedData = getApplicationContext().getSharedPreferences("VGW", android.content.Context.MODE_PRIVATE);
        if(readBooleanData("FIRST EVER")){
            saveData(false,"FIRST EVER");
            clicked = "PLAYER VS. PLAYER";
            NumOfBuild = 6;
            NumOfDS = 3;
            NumOfUnits = 3;
            NumOfSpells = 3;
            useSpells = false;
            SMARTNESSint = 1;
            AlwaysUse = false;
            NUmOfPlayersMax = 3;
            ownedExpansions[0] = true;
            ownedExpansions[1] = false;
            ownedExpansions[2] = false;
            ownedExpansions[3] = false;
            ownedExpansions[4] = false;
            ownedExpansions[5] = false;
        }else{
            clicked = readStringData();
            NumOfBuild = readIntData("NumOfBuild");
            NumOfDS = readIntData("NumOfDS");
            NumOfUnits = readIntData("NumOfUnits");
            NumOfSpells = readIntData("NumOfSpells");
            useSpells = readBooleanData("SpellsNotDefence");
            SMARTNESSint = readIntData("SMARTNESSint");
            AlwaysUse = readBooleanData("AlwaysUse");
            ownedExpansions[0] = readBooleanData("ownedExpansion[0]");
            ownedExpansions[1] = readBooleanData("ownedExpansion[1]");
            ownedExpansions[2] = readBooleanData("ownedExpansion[2]");
            ownedExpansions[3] = readBooleanData("ownedExpansion[3]");
            ownedExpansions[4] = readBooleanData("ownedExpansion[4]");
            ownedExpansions[5] = readBooleanData("ownedExpansion[5]");
            if(ownedExpansions[5]){NUmOfPlayersMax = 4;}else{NUmOfPlayersMax = 3;}
        }
        try{
            main();
        }catch (Exception ignore){
        }
    }

    //-----{MAIN}--------------------------------------------------------------------------------------
    private void main() {
        CurrentScreen = "MAIN";
        setContentView(R.layout.main);
        spinner = findViewById(R.id.spinner1);
        if (ownedExpansions[1] && ownedExpansions[3]) {
            adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                    R.array.spinnerALL, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        } else if (ownedExpansions[1]) {
            adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                    R.array.spinnerGW, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        } else if (ownedExpansions[3]) {
            adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                    R.array.spinnerRAG, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        } else {
            adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                    R.array.spinnerNONE, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        }

        spinner.setAdapter(adapter);

        if (!Random) {
            if (!clicked.equals("")) {
                short spinnerPosition = (short) adapter.getPosition(clicked);
                spinner.setSelection(spinnerPosition);
            }
        } else {
            short spinnerPosition = (short) adapter.getPosition("Random");
            spinner.setSelection(spinnerPosition);
        }


        SMARTNESS = findViewById(R.id.Smartness);
        SmartnessText = findViewById(R.id.smartnessText);
        SpinnerListen sa = new SpinnerListen();
        SeekBarListen sbl = new SeekBarListen();
        spinner.setOnItemSelectedListener(sa);
        randomize = findViewById(R.id.Radomizer);
        settings = findViewById(R.id.settings);
        settings.setOnClickListener(buttonListener);
        randomize.setOnClickListener(buttonListener);
        PLAYERS = findViewById(R.id.PLayers);
        SMARTNESS.setOnSeekBarChangeListener(sbl);
        PLAYERS.setOnSeekBarChangeListener(sbl);

        PlayersText = findViewById(R.id.PlayersText);
        SMARTNESS.setProgress(smartness);
        SpellsNotDefence = findViewById(R.id.SpellNotDefences);
        if (ownedExpansions[2]) {
            SpellsNotDefence.setClickable(true);
            SpellsNotDefence.setVisibility(View.VISIBLE);
            SpellsNotDefence.setChecked(UseSpellsBefore);
        } else {
            SpellsNotDefence.setClickable(false);
            SpellsNotDefence.setVisibility(View.INVISIBLE);
            useSpells = false;
        }
        if (firstTime) {
            firstTime = false;
            SpellsNotDefence.setChecked(useSpells);

            SMARTNESS.setProgress(SMARTNESSint);
            if (SMARTNESS.getProgress() == 0) {
                String dis = "Randomizer  Smartness: \n OFF";
                SmartnessText.setText(dis);
            } else if (SMARTNESS.getProgress() == 1) {
                String dis = "Randomizer  Smartness: \n ONLY IF NECESSARY";
                SmartnessText.setText(dis);
            } else if (SMARTNESS.getProgress() == 2) {
                String dis = "Randomizer  Smartness: \n FOR BETTER COMBOS";
                SmartnessText.setText(dis);
            } else if (SMARTNESS.getProgress() == 3) {
                String dis = "Randomizer  Smartness: \n FOR BEST COMBOS";
                SmartnessText.setText(dis);
            }

        }
        PLAYERS.setMax(NUmOfPlayersMax);
    }

    //------{RANDOMIZE PAGE}----------------------------------------------------------------------------
    private void RANDOMIZE(){
        try{
            randomizeUnits();
            randomizeBuildings();

            if(useSpells){
                if(SpellsNotDefence.isChecked()){
                    randomizeSpells();
                }else{
                    randomizeDefences();
                }
            }else {
                randomizeDefences();
            }
            randomizeEndGameBonuses();
            getOtherNotes();
        }catch (Exception ignore){
        }
    }
    private void randomizeUnits() {
        StringBuilder display = new StringBuilder();
        String[] dis = new String[NumOfUnits];
        short count = 0;
        //--------{Top Name Thing}-------------------------------------------------------------
        getGameType(ownedExpansions);


        TextView UnitsText = findViewById(R.id.unitsList);
        Units = getRandomUnits(NumOfUnits, (short)SMARTNESS.getProgress(),ownedExpansions);
        for (Card currentCard : Units) {
            dis[count] = currentCard.Name;
            count++;
        }
        Arrays.sort(dis);
        for (String disString : dis) {
            display.append(disString).append("\n");
        }
        UnitsText.setText(display.toString());
    }
    private void randomizeBuildings() {
        try {
            StringBuilder display = new StringBuilder();
            String[] dis = new String[NumOfBuild];
            short count = 0;
            TextView BuildingText = findViewById(R.id.buildingsList);

            buildings = getRandomBuilding(NumOfBuild, (short) SMARTNESS.getProgress(),ownedExpansions, AlwaysUse);
            for (Card currentCard : buildings) {
                dis[count] = currentCard.Name;
                count++;
            }
            Arrays.sort(dis);
            for (String disString : dis) {
                display.append(disString).append("\n");
            }
            BuildingText.setText(display.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void randomizeDefences() {
        StringBuilder display = new StringBuilder();
        String[] dis = new String[NumOfDS];
        short count = 0;
        TextView DefenceText = findViewById(R.id.defencesList);
        TextView DefenceTitle = findViewById(R.id.defencesTitle);
        String Spells = "Defenses:";
        DefenceTitle.setText(Spells);
        defences = getRandomDefences(NumOfDS,  (short)SMARTNESS.getProgress(),ownedExpansions);
        for (Card currentCard : defences) {
            dis[count] = currentCard.Name;
            count++;
        }
        Arrays.sort(dis);
        for (String disString : dis) {
            display.append(disString).append("\n");
        }
        DefenceText.setText(display.toString());
    }
    private void randomizeEndGameBonuses() {
        String dis;
        StringBuilder displayEGB = new StringBuilder();
        Card[] EGB;
        short count = 0;
        TextView display =  findViewById(R.id.endGameList);
        if (clicked.equalsIgnoreCase("Ragnarok")) {
            dis = "Objectives";
        } else {
            dis = "End Game Bonuses";
        }
        TextView EGBTitle =  findViewById(R.id.endGameTitle);
        EGBTitle.setText(dis);
        EGB = getEndGameBonuses( (short)SMARTNESS.getProgress(), clicked,ownedExpansions, Units, buildings);

        String[] disArray = new String[EGB.length];
        for (Card currentCard : EGB) {
            disArray[count] = currentCard.Name;
            count++;
        }
        Arrays.sort(disArray);
        for (String disString : disArray) {
            displayEGB.append(disString).append("\n");
        }
        display.setText(displayEGB.toString());
    }
    private void randomizeSpells(){
        try{
            StringBuilder display = new StringBuilder();
            String[] dis = new String[NumOfSpells];
            short count = 0;
            TextView DefenceText =  findViewById(R.id.defencesList);
            TextView DefenceTitle =  findViewById(R.id.defencesTitle);
            String Spells = "Spells:";
            DefenceTitle.setText(Spells);
            defences = getSpells(NumOfSpells, ownedExpansions);
            for (Card currentCard : defences) {
                dis[count] = currentCard.Name;
                count++;
            }
            Arrays.sort(dis);
            for (String disString : dis) {
                display.append(disString).append("\n");
            }
            DefenceText.setText(display.toString());
        }catch (Exception ignore){
        }

    }
    private void getOtherNotes(){
        boolean IsPlayingRag = clicked.equals("Ragnarok");
        boolean IsPlayingGW = clicked.equals("Guild Wars");
        TextView OtherNotesText = findViewById(R.id.noteList);
        OtherNotesText.setText(Cards.getOtherNotes(buildings,Units,defences,
                PLAYERS.getProgress()+1,ownedExpansions[4], IsPlayingRag, IsPlayingGW));
    }


    //-------{LISTENERS}--------------------------------------------------------------------------------
    // BUTTON:
    private class buttonMain implements View.OnClickListener {
        public void onClick(View v) {
            if (v == randomize) {
                CurrentScreen = "RANDOMIZE";
                setContentView(R.layout.randomize);
                restart =  findViewById(R.id.restart);
                restart.setOnClickListener(bRPL);
                reRandomize =  findViewById(R.id.rerandomize);
                reRandomize.setOnClickListener(bRPL);
                RANDOMIZE();

            } else if (v == settings) {
                CurrentScreen = "SETTINGS";
                setContentView(R.layout.settings);
                Button save =  findViewById(R.id.SAVE);
                CheckBox BaseSet =  findViewById(R.id.BaseSet);
                CheckBox GuildWars =  findViewById(R.id.GuildWars);
                CheckBox ItsAKindOfMagic =  findViewById(R.id.ItsAKindOfMagic);
                CheckBox Ragnorok =  findViewById(R.id.Ragnorok);
                CheckBox KickStarter =  findViewById(R.id.KickStarter);
                CheckBox fifthPlayer =  findViewById(R.id.fifthPlayer);
                CheckBox AllUse =  findViewById(R.id.BrewAndGold);
                HowManyBuild =  findViewById(R.id.NumOfBuildings);
                HowManyDS =  findViewById(R.id.NumOfDefenceSpells);
                HowManyUnits =  findViewById(R.id.NumOfUnits);
                HowManySpells = findViewById(R.id.NumOfSpells);
                BaseSet.setChecked(ownedExpansions[0]);
                GuildWars.setChecked(ownedExpansions[1]);
                ItsAKindOfMagic.setChecked(ownedExpansions[2]);
                Ragnorok.setChecked(ownedExpansions[3]);
                KickStarter.setChecked(ownedExpansions[4]);
                fifthPlayer.setChecked(ownedExpansions[5]);
                AllUse.setChecked(AlwaysUse);
                save.setOnClickListener(SPBL);
                HowManyBuild.setOnSeekBarChangeListener(sbl);
                HowManyDS.setOnSeekBarChangeListener(sbl);
                HowManyUnits.setOnSeekBarChangeListener(sbl);
                HowManySpells.setOnSeekBarChangeListener(sbl);
                HowManyBuild.setProgress(NumOfBuild);
                HowManyDS.setProgress(NumOfDS);
                HowManyUnits.setProgress(NumOfUnits);
                HowManySpells.setProgress(NumOfSpells);
                HELP = findViewById(R.id.CryOfHelp);
                HELP.setOnClickListener(buttonListener);

                HowManyBuild.setMax(checkMaxBuildings());
                HowManyDS.setMax(checkMaxDS());
                HowManyUnits.setMax(checkMaxUnits());
                HowManySpells.setMax(checkMaxSpells());

                if(!ownedExpansions[2]){
                    TextView display =  findViewById(R.id.NumberOfSpellsText);
                    display.setVisibility(View.INVISIBLE);
                    HowManySpells.setVisibility(View.INVISIBLE);
                    HowManySpells.setClickable(false);
                }else{
                    TextView display =  findViewById(R.id.NumberOfSpellsText);
                    display.setVisibility(View.VISIBLE);
                    HowManySpells.setVisibility(View.VISIBLE);
                    HowManySpells.setClickable(true);
                    HowManySpells.setMax(6);
                }
            }else if(v == HELP){
                setContentView(R.layout.help);
                CurrentScreen ="HELP";
                String HelpText = "\nABOUT THE RANDOMIZER\nThe randomizer will randomly pick the " +
                        "Buildings, Units, Defenses, or Spells, and will tell you if there is anything" +
                        " extra that you need to add. In the settings you can choose the expansions " +
                        "that you want the randomizer to pick from, and the number of cards of each " +
                        "type (Buildings, Units, etc.) it picks. You also can choose if you want the " +
                        "randomizer to always pick Breweries and Gold factories. On the main page you can select the game type (Ragnarok," +
                        " Player vs. Player, Guild Wars, or Random), and how many people are playing. Also on the main screen is how you choose the" +
                        " randomizer Smartness.\n\nSMARTNESS LEVEL\nThe Smartness Level has four settings, OFF, ONLY IF NECESSARY, FOR BETTER COMBOS," +
                        " and FOR BEST COMBOS. Choosing OFF makes the randomizer chose at complete random. ONLY IF NECESSARY will randomize" +
                        " until it is somewhat smart, like if there is a Beer Container, there is always a Brewery. Also, it will make sure" +
                        " all of the End Game Bonuses are possible. FOR BETTER COMBOS ensures things like that when ever there is a " +
                        "Gold Factory, there is a Gold Container. Also Divine Favor cards will have the cards they need to be a little " +
                        "bit stronger. FOR BEST COMBOS ensures that Odin's Path cards have some not needed other cards, like that Mystery Gift (Unit Card)" +
                        " needs a Gold Container because it gives a Gold Token. \n\nRANDOMIZING SPELLS/DEFENCES\nThe randomizer will randomize " +
                        "with Defenses" +
                        " by default. To randomize with Spells, you have to go to settings, and select the It's A Kind Of Magic expansion. Then on the main " +
                        "page a hidden checkbox will appear. Check it and it will randomize with Spells instead of Defenses.\n\nOTHER NOTES\nThis section on " +
                        "the Randomize Page tells you if there are any extra cards to add, such as 5th Player Cards, KickStarter Cards, and set up for" +
                        " a game of Ragnarok." +
                        "\n\nNUMBER OF PLAYERS\n" +
                        "The information is used in the Other Notes for deciding when to add the 5th Player Cards." +
                        " It is also for deciding how many cards to add" +
                        " for Ragnarok Setup." +
                        "\n\nTYPE OF GAME SELECTION\nThis adds information so Other Notes can tell you if any additional setup is necessary." +
                        "\n\nError Report: fishtankapps@gmail.com\n\n" +
                        "Thanks for downloading, and have fun!!!\n\n";
                TextView HelpTextView = findViewById(R.id.HelpText);
                HelpTextView.setText(HelpText);
                Button Back = findViewById(R.id.CloseHelp);
                Back.setOnClickListener(new buttonHelp());
            }
        }
    } //LISTENER FOR BUTTONS ON THE MAIN PAGE
    private class buttonRandomPage implements View.OnClickListener {
        public void onClick(View v) {
            if (v == restart) {
                smartness = (short)SMARTNESS.getProgress();
                main();

            } else if (v == reRandomize) {
                UseSpellsBefore = SpellsNotDefence.isChecked();
                RANDOMIZE();
            }
        }
    } //LISTENER FOR BUTTONS ON THE RANDOMIZED PAGE
    private class buttonSettings implements View.OnClickListener {
        public void onClick(View v) {
            saveData((short)HowManyBuild.getProgress(),"NumOfBuild");
            saveData((short)HowManyDS.getProgress(),"NumOfDS");
            saveData((short)HowManyUnits.getProgress(),"NumOfUnits");
            setContentView(R.layout.main);
            main();
        }
    }
    private class buttonHelp implements View.OnClickListener{

        public void onClick(View view) {
             Settings();
        }
    }

    // SPINNER:
    private class SpinnerListen implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                  int pos, long id) {
            clicked = parent.getItemAtPosition(pos).toString();
            saveData(parent.getItemAtPosition(pos).toString());
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    // SEEK BAR:
    private class SeekBarListen implements SeekBar.OnSeekBarChangeListener {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(seekBar == SMARTNESS){
                if (SMARTNESS.getProgress() == 0) {
                    String dis = "Randomizer  Smartness: \n OFF";
                    SmartnessText.setText(dis);
                } else if (SMARTNESS.getProgress() == 1) {
                    String dis = "Randomizer  Smartness: \n ONLY IF NECESSARY";
                    SmartnessText.setText(dis);
                } else if (SMARTNESS.getProgress() == 2) {
                    String dis = "Randomizer  Smartness: \n FOR BETTER COMBOS";
                    SmartnessText.setText(dis);
                } else if (SMARTNESS.getProgress() == 3) {
                    String dis = "Randomizer  Smartness: \n FOR BEST COMBOS";
                    SmartnessText.setText(dis);
                }
                saveData((short)SMARTNESS.getProgress(), "SMARTNESSint");
            }else if(seekBar == PLAYERS){
                String dis = "Number of Players: "+(PLAYERS.getProgress()+1)+" Players";
                PlayersText.setText(dis);
            }else  if(seekBar == HowManyBuild){
                TextView display =  findViewById(R.id.NumOfBuildText);
                String dis = "Number of Buildings: "+ HowManyBuild.getProgress();
                NumOfBuild = (short)HowManyBuild.getProgress();
                saveData((short)HowManyBuild.getProgress(),"NumOfBuild");
                display.setText(dis);
            }else  if(seekBar == HowManyDS){
                TextView display =  findViewById(R.id.NumOfDSText);
                String dis = "Number Of Defenses: "+ HowManyDS.getProgress();
                saveData((short)HowManyDS.getProgress(),"NumOfDS");
                NumOfDS = (short)HowManyDS.getProgress();
                display.setText(dis);
            }else  if(seekBar == HowManyUnits){
                TextView display =  findViewById(R.id.NumOfUnitText);
                String dis = "Number Of Units: "+ HowManyUnits.getProgress();
                NumOfUnits = (short)HowManyUnits.getProgress();
                saveData((short)HowManyUnits.getProgress(),"NumOfUnits");
                display.setText(dis);
            }else  if(seekBar == HowManySpells){
                TextView display =  findViewById(R.id.NumberOfSpellsText);
                String dis = "Number Of Spells: "+ HowManySpells.getProgress();
                NumOfSpells =(short) HowManySpells.getProgress();
                saveData((short)HowManySpells.getProgress(),"NumOfSpells");
                display.setText(dis);
            }

        }

        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    // CHECK BOX:
    public void onCheckboxClickedSettings(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        boolean ShouldICheck = true;
        switch (view.getId()) {
            case R.id.BaseSet:
                ownedExpansions[0] = checked;
                saveData(checked, "ownedExpansion[0]");
                break;
            case R.id.GuildWars:
                ownedExpansions[1] = checked;
                saveData(checked, "ownedExpansion[1]");
                break;
            case R.id.ItsAKindOfMagic:
                ownedExpansions[2] = checked;
                saveData(checked, "ownedExpansion[2]");
                if(!checked){
                    TextView display =  findViewById(R.id.NumberOfSpellsText);
                    display.setVisibility(View.INVISIBLE);
                    HowManySpells.setVisibility(View.INVISIBLE);
                    HowManySpells.setClickable(false);
                }else{
                    TextView display =  findViewById(R.id.NumberOfSpellsText);
                    display.setVisibility(View.VISIBLE);
                    HowManySpells.setVisibility(View.VISIBLE);
                    HowManySpells.setClickable(true);
                    HowManySpells.setMax(6);
                }
                break;
            case R.id.Ragnorok:
                ownedExpansions[3] = checked;
                saveData(checked, "ownedExpansion[3]");
                break;
            case R.id.KickStarter:
                ownedExpansions[4] = checked;
                saveData(checked, "ownedExpansion[4]");
                break;
            case R.id.fifthPlayer:
                ownedExpansions[5] = checked;
                saveData(checked, "ownedExpansion[5]");
                if(checked){NUmOfPlayersMax = 4;}else{NUmOfPlayersMax = 3;}
                break;
            case R.id.BrewAndGold:
                AlwaysUse = checked;
                saveData(checked, "AlwaysUse");
                ShouldICheck = false;
                break;
            case R.id.SpellNotDefences:
                try{
                    saveData(checked, "SpellsNotDefence");
                    ShouldICheck = false;
                    useSpells = true;
                    break;
                }catch (Exception ignore){

                }

        }
        if(ShouldICheck){
            HowManyBuild.setMax(checkMaxBuildings());
            HowManyDS.setMax(checkMaxDS());
            HowManyUnits.setMax(checkMaxUnits());
            HowManySpells.setMax(checkMaxSpells());
        }

    }

    //-------{SAVING DATA}------------------------------------------------------------------------------
    //SAVE:
    public void saveData(short data, String StorageName){
        SharedPreferences.Editor editor = savedData.edit();
        editor.putInt(StorageName,data);
        editor.apply();
    }
    public void saveData(boolean data, String StorageName){
        SharedPreferences.Editor editor = savedData.edit();
        editor.putBoolean(StorageName,data);
        editor.apply();
    }
    public void saveData(String data){
        SharedPreferences.Editor editor = savedData.edit();
        editor.putString("clicked",data);
        editor.apply();
    }

    //READ:
    public short readIntData(String StorageName){
        return (short)savedData.getInt(StorageName,0);
    }
    public String readStringData(){
        return savedData.getString("clicked","");
    }
    public boolean readBooleanData(String StorageName){
        return savedData.getBoolean(StorageName,true);
    }

    //--------{GETTING MAXS}---------------------------------------------------------------------------
    public short checkMaxBuildings(){
        short returnValue =0;
        if(ownedExpansions[0]){
             returnValue +=6;
        }
        if(ownedExpansions[1]){
            returnValue +=3;
        }
        if(ownedExpansions[2]){
            returnValue ++;
        }
        if(ownedExpansions[4]){
            returnValue +=2;
        }
        return returnValue;
    }
    public short checkMaxUnits(){
       short returnValue = 0;
       if(ownedExpansions[0]){
           returnValue +=3;
       }
       if(ownedExpansions[1]){
           returnValue +=3;
       }
       if(ownedExpansions[2]){
           returnValue +=3;
       }
       if(ownedExpansions[4]){
           returnValue +=4;
       }
       return  returnValue;
    }
    public short checkMaxDS(){
        short returnValue = 0;
        if(ownedExpansions[0]){
            returnValue +=3;
        }
        if(ownedExpansions[1]){
            returnValue ++;
        }
        return  returnValue;
    }
    public short checkMaxSpells(){

        if(ownedExpansions[2]){
            return 6;
        }
        return  0;
    }

    //--------{BACK BUTTON STUFF}----------------------------------------------------------------------
    public void onBackPressed() {
        switch (CurrentScreen) {
            case "MAIN":
                this.finishAffinity();
                break;
            case "HELP":
                Settings();
                break;
            default:
                main();
                break;
        }

    }
    public void Settings(){
        CurrentScreen = "SETTINGS";
        setContentView(R.layout.settings);
        Button save =  findViewById(R.id.SAVE);
        CheckBox BaseSet =  findViewById(R.id.BaseSet);
        CheckBox GuildWars =  findViewById(R.id.GuildWars);
        CheckBox ItsAKindOfMagic =  findViewById(R.id.ItsAKindOfMagic);
        CheckBox Ragnorok =  findViewById(R.id.Ragnorok);
        CheckBox KickStarter =  findViewById(R.id.KickStarter);
        CheckBox fifthPlayer =  findViewById(R.id.fifthPlayer);
        CheckBox AllUse =  findViewById(R.id.BrewAndGold);
        HowManyBuild =  findViewById(R.id.NumOfBuildings);
        HowManyDS =  findViewById(R.id.NumOfDefenceSpells);
        HowManyUnits =  findViewById(R.id.NumOfUnits);
        HowManySpells = findViewById(R.id.NumOfSpells);
        BaseSet.setChecked(ownedExpansions[0]);
        GuildWars.setChecked(ownedExpansions[1]);
        ItsAKindOfMagic.setChecked(ownedExpansions[2]);
        Ragnorok.setChecked(ownedExpansions[3]);
        KickStarter.setChecked(ownedExpansions[4]);
        fifthPlayer.setChecked(ownedExpansions[5]);
        AllUse.setChecked(AlwaysUse);
        save.setOnClickListener(SPBL);
        HowManyBuild.setOnSeekBarChangeListener(sbl);
        HowManyDS.setOnSeekBarChangeListener(sbl);
        HowManyUnits.setOnSeekBarChangeListener(sbl);
        HowManySpells.setOnSeekBarChangeListener(sbl);
        HowManyBuild.setProgress(NumOfBuild);
        HowManyDS.setProgress(NumOfDS);
        HowManyUnits.setProgress(NumOfUnits);
        HowManySpells.setProgress(NumOfSpells);
        HELP = findViewById(R.id.CryOfHelp);
        HELP.setOnClickListener(buttonListener);
        HowManyBuild.setMax(checkMaxBuildings());
        HowManyDS.setMax(checkMaxDS());
        HowManyUnits.setMax(checkMaxUnits());
        HowManySpells.setMax(checkMaxSpells());
    }

    //--------{TOOLS}----------------------------------------------------------------------------------
    public void getGameType(boolean[] ownedExpansions){
        boolean GOOD = false;
        while (!GOOD){
            if (clicked.equals("Random") || Random) {
                Random = true;
                short code = (short) (Math.random() * 3);
                if (code == 0) {
                    GOOD = ownedExpansions[3];
                    clicked = "Ragnarok";
                } else if (code == 1) {
                    clicked = "Guild Wars";
                    GOOD = ownedExpansions[1];
                } else if (code == 2) {
                    clicked = "Player vs. Player";
                    GOOD = true;
                }
                String dis2 = "Game Mode: " + clicked;
                modeText =  findViewById(R.id.gameMode);
                modeText.setText(dis2);
            } else {
                String dis2 = "Game Mode: " + clicked;
                modeText =  findViewById(R.id.gameMode);
                modeText.setText(dis2);
                GOOD = true;
            }
        }

    }
}