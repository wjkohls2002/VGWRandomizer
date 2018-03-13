package com.example.toast.vgwrandomizer;

class Cards extends CardStuff{
    private static Card[] allCards = new Card[252];
    private static boolean RandomizedFlying = false;
    private static boolean RandomizedFlying2 = false;
 //   +0 means doesn't matter, +30000 means only on randomizer smart 3, 20000 = 2, 10000 means ABSOLUTELY NECESSARY +40000 means OR another attribute

//-------------{STUFF WITH allCards ARRAY}--------------------------------------------------------------------------------------------------------------
    static class Card{
        String Name = "";
        short TypeOfCard = 0;
        int [] keyAttributes = {0,0,0,0,0};
        short Expansion = 0;
        int numOfCardsInGame = 0;
        private Card(String Name, short TypeOfCard, short Expansion, int numOfCardsInGame, int[] keyAttributes){
            this.Name = Name;
            this.TypeOfCard = TypeOfCard;
            this.Expansion = Expansion;
            this.numOfCardsInGame = numOfCardsInGame;
            this.keyAttributes = keyAttributes;
        }
        private static int[] composeKeyAttributes(int keyAttribute1,int keyAttribute2,int keyAttribute3,int keyAttribute4,int keyAttribute5){
            return new int[]{keyAttribute1,keyAttribute2,keyAttribute3,keyAttribute4,keyAttribute5};
        }

    }
    static Card[] composeDecks() {
        allCards[1] = new Card("Alviss", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[2] = new Card("Beer Container", Buildings, BaseSet, 8, Card.composeKeyAttributes(StoreBeer + 10000, Null, Null, Null, Null));
        allCards[3] = new Card("Beer Taxes", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[4] = new Card("Bone Crusher", Units, BaseSet, 6, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[5] = new Card("Brewery", Buildings, BaseSet, 12, Card.composeKeyAttributes(GivesBeerToken, NeedsBeerStorage + 20000, Null, Null, Null));
        allCards[6] = new Card("Cannon", Defences, BaseSet, 6, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[7] = new Card("Chicken Tower", Defences, BaseSet, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[8] = new Card("Drakkar", Buildings, BaseSet, 6, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[9] = new Card("Dvergar", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(NeedsBrewery + 10000, Null, Null, Null, Null));
        allCards[10] = new Card("Elf Archer", Units, BaseSet, 8, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[11] = new Card("Gold Container", Buildings, BaseSet, 8, Card.composeKeyAttributes(StoreGold + 10000, Null, Null, Null, Null));
        allCards[12] = new Card("Gold Factory", Buildings, BaseSet, 12, Card.composeKeyAttributes(GivesGoldToken, NeedsGoldStorage + 20000, Null, Null, Null));
        allCards[13] = new Card("Gold Taxes", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[14] = new Card("Grendel", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[15] = new Card("Pigator", Units, BaseSet, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[16] = new Card("Sheep Cannon", Defences, BaseSet, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[17] = new Card("Tavern", Buildings, BaseSet, 6, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[18] = new Card("Loki's Lens", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[19] = new Card("Mjöllnir", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[20] = new Card("Resurrection", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[21] = new Card("Thor", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[22] = new Card("Time Manipulation", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[23] = new Card("Treasure Chest", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[24] = new Card("Valkyrie", DivineFavors, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[25] = new Card("Undead (Gold Giver)", OdinPath, BaseSet, 2, Card.composeKeyAttributes(GivesGoldToken, NeedsGoldStorage + 20000, Null, Null, Null));
        allCards[26] = new Card("Undead (Beer Giver)", OdinPath, BaseSet, 2, Card.composeKeyAttributes(GivesBeerToken, NeedsBeerStorage + 20000, Null, Null, Null));
        allCards[27] = new Card("Sword", OdinPath, BaseSet, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[28] = new Card("Shockwave Tower", OdinPath, BaseSet, 3, Card.composeKeyAttributes(IsADefence, Null, Null, Null, Null));
        allCards[29] = new Card("Shaman", OdinPath, BaseSet, 2, Card.composeKeyAttributes(IsAUnits, Null, Null, Null, Null));
        allCards[30] = new Card("Scroll", OdinPath, BaseSet, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[31] = new Card("Recipe Theft", OdinPath, BaseSet, 2, Card.composeKeyAttributes(TakesABeerToken, NeedsBeerStorage + 30000, Null, Null, Null));
        allCards[32] = new Card("Odin's Boost", OdinPath, BaseSet, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[33] = new Card("Mystery Gift (Resource Card)", OdinPath, BaseSet, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[34] = new Card("Mystery Gift (Unit Card)", OdinPath, BaseSet, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[35] = new Card("Money Theft", OdinPath, BaseSet, 2, Card.composeKeyAttributes(TakesAGoldToken, NeedsGoldStorage + 30000, Null, Null, Null));
        allCards[36] = new Card("Hero Trap", OdinPath, BaseSet, 1, Card.composeKeyAttributes(IsADiscardDefence, Null, Null, Null, Null));
        allCards[37] = new Card("Gold Miner", OdinPath, BaseSet, 2, Card.composeKeyAttributes(NeedsAGoldFactory + 10000, Null, Null, Null, Null));
        allCards[38] = new Card("Gold Bars", OdinPath, BaseSet, 3, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[39] = new Card("Crystal", OdinPath, BaseSet, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[40] = new Card("Beer Specialist", OdinPath, BaseSet, 2, Card.composeKeyAttributes(NeedsBrewery + 10000, Null, Null, Null, Null));
        allCards[41] = new Card("Beer Mugs", OdinPath, BaseSet, 3, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[42] = new Card("Bear Rider", OdinPath, BaseSet, 2, Card.composeKeyAttributes(IsAUnits, Null, Null, Null, Null));
        allCards[43] = new Card("Assassin", OdinPath, BaseSet, 2, Card.composeKeyAttributes(IsAUnits, IsADiscardDefence, Null, Null, Null));
        allCards[44] = new Card("Follower", EndGameBonuses, BaseSet, 1, Card.composeKeyAttributes(NeedsOdinsPath + 10000, Null, Null, Null, Null));
        allCards[45] = new Card("Miner", EndGameBonuses, BaseSet, 1, Card.composeKeyAttributes(NeedsGoldStorage + 10000, Null, Null, Null, Null));
        allCards[46] = new Card("Conqueror", EndGameBonuses, BaseSet, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[47] = new Card("Builder", EndGameBonuses, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[48] = new Card("Accomplisher", EndGameBonuses, BaseSet, 1, Card.composeKeyAttributes(NeedsMissions + 10000, Null, Null, Null, Null));
        allCards[49] = new Card("Beer Tycoon", EndGameBonuses, BaseSet, 1, Card.composeKeyAttributes(NeedsBeerStorage + 10000, Null, Null, Null, Null));
        allCards[50] = new Card("Defender", EndGameBonuses, BaseSet, 1, Card.composeKeyAttributes(NeedsDefence + 10000, Null, Null, Null, Null));
        allCards[51] = new Card("King Pig", EndGameBonuses, BaseSet, 1, Card.composeKeyAttributes(NeedsPigator + 10000, Null, Null, Null, Null));
        allCards[52] = new Card("Worship", Missions, BaseSet, 2, Card.composeKeyAttributes(NeedsOdinsPath + 10000, Null, Null, Null, Null));
        allCards[53] = new Card("Money, Money", Missions, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[54] = new Card("Worker", Missions, BaseSet, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[55] = new Card("Strategy", Missions, BaseSet, 2, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[56] = new Card("Town Fall", Missions, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[57] = new Card("Brewer", Missions, BaseSet, 1, Card.composeKeyAttributes(NeedsBrewery + 10000, Null, Null, Null, Null));
        allCards[58] = new Card("Attacker", Missions, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[59] = new Card("Captain", Missions, BaseSet, 1, Card.composeKeyAttributes(NeedsDrakkar + 10000, Null, Null, Null, Null));
        allCards[60] = new Card("Architect", Missions, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[61] = new Card("Shield", Missions, BaseSet, 2, Card.composeKeyAttributes(NeedsDefence + 10000, Null, Null, Null, Null));
        allCards[62] = new Card("Thirsty?", Missions, BaseSet, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[63] = new Card("Foundry", Missions, BaseSet, 1, Card.composeKeyAttributes(NeedsAGoldFactory + 10000, Null, Null, Null, Null));
        allCards[64] = new Card("Warfare", Missions, BaseSet, 1, Card.composeKeyAttributes(Needs4PlusUnit + 10000, Null, Null, Null, Null));
        allCards[65] = new Card("Innkeeper", Missions, BaseSet, 1, Card.composeKeyAttributes(NeedsTavern + 10000, Null, Null, Null, Null));
        allCards[66] = new Card("Beer!", Missions, BaseSet, 1, Card.composeKeyAttributes(NeedsBrewery + 10000, Null, Null, Null, Null));
        allCards[67] = new Card("Gold!", Missions, BaseSet, 1, Card.composeKeyAttributes(NeedsAGoldFactory + 10000, Null, Null, Null, Null));
        allCards[68] = new Card("Sea Serpent", Units, KickStarter, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[69] = new Card("Odin's Hound", Units, KickStarter, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[70] = new Card("Mortar Turtle", Units, KickStarter, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[71] = new Card("Banshee", Units, KickStarter, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[72] = new Card("Hall of Ancestors", Buildings, KickStarter, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[73] = new Card("Nectar Factory", Buildings, KickStarter, 8, Card.composeKeyAttributes(GivesGoldToken, GivesBeerToken, NeedsBeerStorage + 20000, NeedsGoldStorage + 20000, Null));
        allCards[74] = new Card("Bragi", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(NeedsNectarFactory + 10000, Null, Null, Null, Null));
        allCards[75] = new Card("Dragon Tower", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(IsADefence, Null, Null, Null, Null));
        allCards[76] = new Card("Fenrir", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[77] = new Card("Helga", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[78] = new Card("Berserker", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[79] = new Card("Gungnir", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(NeedsAHero + 20000, NeedsAUnit + 20000, Null, Null, Null));
        allCards[80] = new Card("Freya", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[81] = new Card("Master Turtles", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(IsADefence, Null, Null, Null, Null));
        allCards[82] = new Card("Assassin Master", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[83] = new Card("Gold Protection", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(IsADefence, NeedsAGoldFactory + 20000, Null, Null, Null));
        allCards[84] = new Card("The Old Ancient", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[85] = new Card("Huguinn & Muninn", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[86] = new Card("Odin", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[87] = new Card("Tyr", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[88] = new Card("Chickens Rampage", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(IsADefence, Null, Null, Null, Null));
        allCards[89] = new Card("Wayland", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[90] = new Card("Barbarian", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[91] = new Card("Sif", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[92] = new Card("Asgard Gate", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[93] = new Card("Jörmungandr", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(NeedsDrakkar + 20000, Null, Null, Null, Null));
        allCards[94] = new Card("Loki", DivineFavors, KickStarter, 1, Card.composeKeyAttributes(TakesABeerToken, TakesAGoldToken, NeedsBeerStorage + 30000, NeedsGoldStorage + 30000, Null));
        allCards[95] = new Card("Bone Crusher (KickStarter)", Units, KickStarter, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[96] = new Card("Elf Archer (KickStarter)", Units, KickStarter, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[97] = new Card("Pigator (KickStarter)", Units, KickStarter, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[98] = new Card("Chicken Tower (KickStarter)", Defences, KickStarter, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[99] = new Card("Sheep Cannon (KickStarter)", Defences, KickStarter, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[100] = new Card("Heroes", EndGameBonuses, KickStarter, 1, Card.composeKeyAttributes(NeedsAHero + 10000, Null, Null, Null, Null));
        allCards[101] = new Card("Girl Power", EndGameBonuses, KickStarter, 1, Card.composeKeyAttributes(NeedsBanshee + 10000, Null, Null, Null, Null));
        allCards[102] = new Card("Turtle Warrior", EndGameBonuses, KickStarter, 1, Card.composeKeyAttributes(NeedsMortarTurtles + 10000, Null, Null, Null, Null));
        allCards[103] = new Card("Warriors", EndGameBonuses, KickStarter, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[104] = new Card("Merchant", EndGameBonuses, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[105] = new Card("Wolf Mask", OdinPath, KickStarter, 2, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[106] = new Card("Wayland's Anvil", OdinPath, KickStarter, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[107] = new Card("War Banner", OdinPath, KickStarter, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[108] = new Card("War Axe", OdinPath, KickStarter, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[109] = new Card("Sword (KickStarter)", OdinPath, KickStarter, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, IsForKickStarter, Null, Null, Null));
        allCards[110] = new Card("Strength Potion", OdinPath, KickStarter, 2, Card.composeKeyAttributes(NeedsDefence + 10000, NeedsAUnit + 10000, Null, Null, Null));
        allCards[111] = new Card("Scroll (KickStarter)", OdinPath, KickStarter, 1, Card.composeKeyAttributes(IsForKickStarter, Null, Null, Null, Null));
        allCards[112] = new Card("Resource Potion", OdinPath, KickStarter, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[113] = new Card("Recipe Theft (KickStarter)", OdinPath, KickStarter, 1, Card.composeKeyAttributes(TakesABeerToken, NeedsBeerStorage + 20000, IsForKickStarter, Null, Null));
        allCards[114] = new Card("Mystery Gift (Defence)", OdinPath, KickStarter, 1, Card.composeKeyAttributes(NeedsDefence + 20000, Null, Null, Null, Null));
        allCards[115] = new Card("Mystery Gift (Action Card)", OdinPath, KickStarter, 1, Card.composeKeyAttributes(NeedsOdinsPath + 20000, Null, Null, Null, Null));
        allCards[116] = new Card("Money Theft (KickStarter)", OdinPath, KickStarter, 1, Card.composeKeyAttributes(TakesAGoldToken, NeedsGoldStorage + 20000, IsForKickStarter, Null, Null));
        allCards[117] = new Card("Madness", OdinPath, KickStarter, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[118] = new Card("Hero Trap (KickStarter)", OdinPath, KickStarter, 1, Card.composeKeyAttributes(IsADiscardDefence, IsForKickStarter, Null, Null, Null));
        allCards[119] = new Card("Cursed Gold", OdinPath, KickStarter, 2, Card.composeKeyAttributes(TakesAGoldToken, Null, Null, Null, Null));
        allCards[120] = new Card("Crow", OdinPath, KickStarter, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[121] = new Card("Beer Bribe", OdinPath, KickStarter, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[122] = new Card("Battle Scream", OdinPath, KickStarter, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[123] = new Card("Thirsty? (KickStarter)", Missions, KickStarter, 1, Card.composeKeyAttributes(IsForKickStarter, Null, Null, Null, Null));
        allCards[124] = new Card("Indestructible", Missions, KickStarter, 1, Card.composeKeyAttributes(NeedsDefence + 10000, Null, Null, Null, Null));
        allCards[125] = new Card("Great Village", Missions, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[126] = new Card("Nectar", Missions, KickStarter, 1, Card.composeKeyAttributes(NeedsNectarFactory + 10000, Null, Null, Null, Null));
        allCards[127] = new Card("Fight Club", Missions, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[128] = new Card("Money, Money (KickStarter", Missions, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[129] = new Card("Destructor", Missions, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[130] = new Card("Shield (KickStarter)", Missions, KickStarter, 1, Card.composeKeyAttributes(IsForKickStarter, Null, Null, Null, Null));
        allCards[131] = new Card("Odin's Blessing", Events, KickStarter, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[132] = new Card("Economizer", Events, KickStarter, 1, Card.composeKeyAttributes(NeedsBeerStorage + 40000, NeedsGoldStorage + 40000, Null, Null, Null));
        allCards[133] = new Card("Odin's Beer", Events, KickStarter, 1, Card.composeKeyAttributes(GivesBeerToken, Null, Null, Null, Null));
        allCards[134] = new Card("Producer", Events, KickStarter, 1, Card.composeKeyAttributes(NeedsBrewery + 400000, NeedsAGoldFactory + 40000, Null, Null, Null));
        allCards[135] = new Card("Shortage of Beer", Events, KickStarter, 1, Card.composeKeyAttributes(NeedsBeerStorage + 10000, Null, Null, Null, Null));
        allCards[136] = new Card("Architect Event", Events, KickStarter, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[137] = new Card("Maelstrom", Events, KickStarter, 2, Card.composeKeyAttributes(NeedsDrakkar + 10000, Null, Null, Null, Null));
        allCards[138] = new Card("Odin's Gold", Events, KickStarter, 1, Card.composeKeyAttributes(GivesGoldToken, NeedsGoldStorage + 3000, Null, Null, Null));
        allCards[139] = new Card("Odin's Wrath", Events, KickStarter, 1, Card.composeKeyAttributes(TakesABeerToken, TakesAGoldToken, Null, Null, Null));
        allCards[140] = new Card("Gold Abundance", Events, KickStarter, 1, Card.composeKeyAttributes(NeedsGoldStorage + 10000, Null, Null, Null, Null));
        allCards[141] = new Card("Hel", DivineFavors, ItsAKindOfMagic, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[142] = new Card("Dragon Master", EndGameBonuses, ItsAKindOfMagic, 1, Card.composeKeyAttributes(NeedsDreki + 10000, Null, Null, Null, Null));
        allCards[143] = new Card("Magic Master", DivineFavors, ItsAKindOfMagic, 1, Card.composeKeyAttributes(NeedsSpells + 10000, Null, Null, Null, Null));
        allCards[144] = new Card("Counter Spell", Missions, ItsAKindOfMagic, 2, Card.composeKeyAttributes(NeedsCancelSpell + 10000, Null, Null, Null, Null));
        allCards[145] = new Card("Dreki Tamer", Missions, ItsAKindOfMagic, 1, Card.composeKeyAttributes(NeedsDreki + 10000, Null, Null, Null, Null));
        allCards[146] = new Card("Warlock", Missions, ItsAKindOfMagic, 1, Card.composeKeyAttributes(NeedsSpells + 10000, Null, Null, Null, Null));
        allCards[147] = new Card("Sorceress", Missions, ItsAKindOfMagic, 1, Card.composeKeyAttributes(NeedsSorceressTower + 10000, Null, Null, Null, Null));
        allCards[148] = new Card("Necronomicon", OdinPath, ItsAKindOfMagic, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[149] = new Card("Zap Trap", OdinPath, ItsAKindOfMagic, 2, Card.composeKeyAttributes(IsADiscardDefence, IsASpell, Null, Null, Null));
        allCards[150] = new Card("Sheep Storm", OdinPath, ItsAKindOfMagic, 2, Card.composeKeyAttributes(ProducesCurses, IsASpell, Null, Null, Null));
        allCards[151] = new Card("Destruction", OdinPath, ItsAKindOfMagic, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[152] = new Card("Sorceresses Tower", Buildings, ItsAKindOfMagic, 12, Card.composeKeyAttributes(ProducesCurses, ProducesBlessings, Null, Null, Null));
        allCards[153] = new Card("Dreki", Units, ItsAKindOfMagic, 4, Card.composeKeyAttributes(doNotForgetDrekiEgg, Null, Null, Null, Null));
        allCards[154] = new Card("Sorceress", Units, ItsAKindOfMagic, 6, Card.composeKeyAttributes(CancelsSpell, NeedsSpells + 20000, Null, Null, Null));
        allCards[155] = new Card("Shaman (It's A Kind Of Magic)", Units, ItsAKindOfMagic, 8, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[156] = new Card("Magic Manipulation", Spells, ItsAKindOfMagic, 10, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[157] = new Card("Alchemy", Spells, ItsAKindOfMagic, 10, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[158] = new Card("Gold Touch", Spells, ItsAKindOfMagic, 10, Card.composeKeyAttributes(GivesGoldToken, NeedsGoldStorage + 20000, Null, Null, Null));
        allCards[159] = new Card("Magic Intervention", Spells, ItsAKindOfMagic, 10, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[160] = new Card("Magic Potion", Spells, ItsAKindOfMagic, 10, Card.composeKeyAttributes(GivesBeerToken, NeedsBeerStorage + 20000, Null, Null, Null));
        allCards[161] = new Card("Cursed Trap", Spells, ItsAKindOfMagic, 10, Card.composeKeyAttributes(IsADefence, ProducesCurses, Null, Null, Null));
        allCards[162] = new Card("Bear Rider (Guild Wars)", Units, GuildWars, 8, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[163] = new Card("Fairy", Units, GuildWars, 8, Card.composeKeyAttributes(Flying, NeedsWalls + 20000, Null, Null, Null));
        allCards[164] = new Card("Wall Breaker", Units, GuildWars, 6, Card.composeKeyAttributes(BreaksWalls, NeedsWalls + 30000, Null, Null, Null));
        allCards[165] = new Card("Siege Master", EndGameBonuses, GuildWars, 1, Card.composeKeyAttributes(NeedsWallBreakers + 10000, Null, Null, Null, Null));
        allCards[166] = new Card("The Great Wall", EndGameBonuses, GuildWars, 1, Card.composeKeyAttributes(NeedsWalls + 10000, Null, Null, Null, Null));
        allCards[167] = new Card("Frequent Flier", EndGameBonuses, GuildWars, 1, Card.composeKeyAttributes(NeedsFlying + 10000, Null, Null, Null, Null));
        allCards[168] = new Card("Anti Air Tower", Defences, GuildWars, 8, Card.composeKeyAttributes(NeedsFlying + 20000, Null, Null, Null, Null));
        allCards[169] = new Card("Ragnar", DivineFavors, GuildWars, 1, Card.composeKeyAttributes(Flying, NeedsWalls + 20000, Null, Null, Null));
        allCards[170] = new Card("Cow Trap", OdinPath, GuildWars, 2, Card.composeKeyAttributes(NeedsFlying + 10000, Null, Null, Null, Null));
        allCards[171] = new Card("Hero Trap", OdinPath, GuildWars, 2, Card.composeKeyAttributes(NeedsAHero + 10000, IsADiscardDefence, Null, Null, Null));
        allCards[172] = new Card("War Axe", OdinPath, GuildWars, 2, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[173] = new Card("Dwarf", OdinPath, GuildWars, 2, Card.composeKeyAttributes(BreaksWalls, IsAUnits, NeedsWalls + 10000, Null, Null));
        allCards[174] = new Card("Valkyrie Wings", OdinPath, GuildWars, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Flying, Null, Null, Null));
        allCards[175] = new Card("Goblin Copter", OdinPath, GuildWars, 2, Card.composeKeyAttributes(Flying, IsAUnits, NeedsWalls + 2000, Null, Null));
        allCards[176] = new Card("Mini Cannon", OdinPath, GuildWars, 2, Card.composeKeyAttributes(IsADefence, NeedsAUnit + 20000, Null, Null, Null));
        allCards[177] = new Card("Transporter", OdinPath, GuildWars, 3, Card.composeKeyAttributes(Flying, IsAUnits, NeedsWalls + 20000, Null, Null));
        allCards[178] = new Card("Fortress", Missions, GuildWars, 1, Card.composeKeyAttributes(NeedsWalls + 10000, Null, Null, Null, Null));
        allCards[179] = new Card("Break That Wall!", Missions, GuildWars, 1, Card.composeKeyAttributes(NeedsWalls + 10000, Null, Null, Null, Null));
        allCards[180] = new Card("Learn To Fly", Missions, GuildWars, 2, Card.composeKeyAttributes(NeedsFlying + 10000, Null, Null, Null, Null));
        allCards[181] = new Card("Build That Wall!", Missions, GuildWars, 2, Card.composeKeyAttributes(NeedsWalls + 10000, Null, Null, Null, Null));
        allCards[182] = new Card("Blacksmith", Missions, GuildWars, 1, Card.composeKeyAttributes(NeedsForge + 10000, Null, Null, Null, Null));
        allCards[183] = new Card("Boost", Missions, GuildWars, 1, Card.composeKeyAttributes(NeedsBoostTower + 10000, Null, Null, Null, Null));
        allCards[184] = new Card("For The Guild", Missions, GuildWars, 2, Card.composeKeyAttributes(Needs2vs2 + 10000, Null, Null, Null, Null));
        allCards[185] = new Card("Guild Defenses", Missions, GuildWars, 2, Card.composeKeyAttributes(NeedsDefence + 10000, Needs2vs2 + 10000, Null, Null, Null));
        allCards[186] = new Card("Guild Forces", Missions, GuildWars, 2, Card.composeKeyAttributes(Needs2vs2 + 10000, NeedsAUnit + 10000, Null, Null, Null));
        allCards[187] = new Card("Helper", Missions, GuildWars, 2, Card.composeKeyAttributes(Needs2vs2 + 10000, Null, Null, Null, Null));
        allCards[188] = new Card("Wall Builder", Buildings, GuildWars, 8, Card.composeKeyAttributes(BuildWalls, Null, Null, Null, Null));
        allCards[189] = new Card("Boost Tower", Buildings, GuildWars, 12, Card.composeKeyAttributes(ProducesDefenceBoosts, Null, Null, Null, Null));
        allCards[190] = new Card("Forge", Buildings, GuildWars, 12, Card.composeKeyAttributes(ProducesAttackBoosts, Null, Null, Null, Null));
        allCards[191] = new Card("Strategy (Fifth Player)", Missions, FifthPlayer, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, IsFor5Players, Null, Null, Null));
        allCards[192] = new Card("Thirsty? (Fifth Player)", Missions, FifthPlayer, 1, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[193] = new Card("Worship (Fifth Player)",Missions, FifthPlayer, 1, Card.composeKeyAttributes(NeedsOdinsPath + 10000, IsFor5Players, Null, Null, Null));
        allCards[194] = new Card("Money, Money (Fifth Player)",Missions, FifthPlayer, 1, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[195] = new Card("Attacker (Fifth Player)",Missions, FifthPlayer, 1, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[196] = new Card("Beer Container (Fifth Player)", Buildings, FifthPlayer, 2, Card.composeKeyAttributes(StoreBeer + 10000, IsFor5Players, Null, Null, Null));
        allCards[197] = new Card("Tavern (Fifth Player)", Buildings, FifthPlayer, 2, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[198] = new Card("Gold Container (Fifth Player)", Buildings, FifthPlayer, 2, Card.composeKeyAttributes(StoreGold + 10000, IsFor5Players, Null, Null, Null));
        allCards[199] = new Card("Gold Factory (Fifth Player)", Buildings, FifthPlayer, 3, Card.composeKeyAttributes(GivesGoldToken, NeedsGoldStorage + 20000, IsFor5Players, Null, Null));
        allCards[200] = new Card("Drakkar (Fifth Player)", Buildings, FifthPlayer, 2, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[201] = new Card("Brewery (Fifth Player)", Buildings, FifthPlayer, 2, Card.composeKeyAttributes(GivesBeerToken, NeedsBeerStorage + 20000, IsFor5Players, Null, Null));
        allCards[202] = new Card("Bone Crusher (Fifth Player)", Units, FifthPlayer, 2, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[203] = new Card("Pigator (Fifth Player)", Units, FifthPlayer, 1, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[204] = new Card("Elf Archer(Fifth Player)", Units, FifthPlayer, 4, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[205] = new Card("Sheep Cannon (Fifth Player)", Defences, FifthPlayer, 1, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[206] = new Card("Chicken Tower (Fifth Player)", Defences, FifthPlayer, 2, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[207] = new Card("Cannon (Fifth Player)", Defences, FifthPlayer, 3, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[208] = new Card("Shockwave Tower (Fifth Player)", OdinPath, FifthPlayer, 1, Card.composeKeyAttributes(IsADefence, IsFor5Players, Null, Null, Null));
        allCards[209] = new Card("Beer Mugs (Fifth Player)", OdinPath, FifthPlayer, 1, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[210] = new Card("Gold Bars (Fifth Player)", OdinPath, FifthPlayer, 1, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[211] = new Card("Money Theft (Fifth Player)", OdinPath, FifthPlayer, 1, Card.composeKeyAttributes(TakesAGoldToken, NeedsGoldStorage + 30000, IsFor5Players, Null, Null));
        allCards[212] = new Card("Scroll (Fifth Player)", OdinPath, FifthPlayer, 1, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[213] = new Card("Recipe Theft (Fifth Player)", OdinPath, FifthPlayer, 1, Card.composeKeyAttributes(TakesABeerToken, NeedsBeerStorage + 30000, IsFor5Players, Null, Null));
        allCards[214] = new Card("Mystery Gift (Resource Card)(Fifth Player)", OdinPath, FifthPlayer, 1, Card.composeKeyAttributes(IsFor5Players, Null, Null, Null, Null));
        allCards[215] = new Card("Undead (Gold Giver) (Fifth Player)", OdinPath, FifthPlayer, 1, Card.composeKeyAttributes(GivesGoldToken, NeedsGoldStorage + 20000, IsFor5Players, Null, Null));
        allCards[216] = new Card("Undead (Beer Giver) (Fifth Player)", OdinPath, FifthPlayer, 1, Card.composeKeyAttributes(GivesBeerToken, NeedsBeerStorage + 20000, IsFor5Players, Null, Null));
        allCards[217] = new Card("Dark Thor", Boss, Ragnarok, 1, Card.composeKeyAttributes(NeedsDrakkar + 20000, Null, Null, Null, Null));
        allCards[218] = new Card("Winter Grendel", Boss, Ragnarok, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[219] = new Card("Dark Fenrir", Boss, Ragnarok, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[220] = new Card("Dark Freya", Boss, Ragnarok, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[221] = new Card("Dark Alviss", Boss, Ragnarok, 1, Card.composeKeyAttributes(NeedsTavern + 20000, Null, Null, Null, Null));
        allCards[222] = new Card("Glass Always Full", EndGameBonuses, Ragnarok, 1, Card.composeKeyAttributes(NeedsBeerStorage + 10000, Null, Null, Null, Null));
        allCards[223] = new Card("Army Of Living", EndGameBonuses, Ragnarok, 1, Card.composeKeyAttributes(NeedsAUnit + 10000, Null, Null, Null, Null));
        allCards[224] = new Card("The Great Village", EndGameBonuses, Ragnarok, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[225] = new Card("No Shortage", EndGameBonuses, Ragnarok, 1, Card.composeKeyAttributes(NeedsBeerStorage, Null, Null, Null, Null));
        allCards[226] = new Card("The Great Clan", EndGameBonuses, Ragnarok, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[227] = new Card("Shield Against Death", EndGameBonuses, Ragnarok, 1, Card.composeKeyAttributes(NeedsDefence + 10000, Null, Null, Null, Null));
        allCards[228] = new Card("Reconstruction", EndGameBonuses, Ragnarok, 1, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[229] = new Card("Dark Cannon", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(IsABuilding, NeedsADarkBuilding + 20000, Null, Null, Null));
        allCards[230] = new Card("Warrior", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(IsAChallenge, Null, Null, Null, Null));
        allCards[231] = new Card("Dead Hall", UndeadArmy, Ragnarok, 2, Card.composeKeyAttributes(IsABuilding, Null, Null, Null, Null));
        allCards[232] = new Card("Headless Rider", UndeadArmy, Ragnarok, 4, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[233] = new Card("Odin's Army", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(IsAChallenge, NeedsAUnit + 10000, Null, Null, Null));
        allCards[234] = new Card("Dark Pigator", UndeadArmy, Ragnarok, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[235] = new Card("Dark Bear Rider", UndeadArmy, Ragnarok, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[236] = new Card("Crushenstein", UndeadArmy, Ragnarok, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[237] = new Card("Town Hall", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(IsAChallenge, Null, Null, Null, Null));
        allCards[238] = new Card("Cursed Tower", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(IsABuilding, NeedsADarkBuilding, Null, Null, Null));
        allCards[239] = new Card("Undead (Ragnarok)", UndeadArmy, Ragnarok, 4, Card.composeKeyAttributes(Null, Null, Null + 20000, Null, Null));
        allCards[240] = new Card("Hell Gate", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(IsABuilding, Null, Null, Null, Null));
        allCards[241] = new Card("Construction", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(IsAChallenge, Null, Null, Null, Null));
        allCards[242] = new Card("Dark Elf", UndeadArmy, Ragnarok, 3, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[243] = new Card("Producer", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(NeedsAProducer, Null, Null, Null, Null));
        allCards[244] = new Card("Dark Sheep Cannon", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(IsABuilding, NeedsADarkBuilding + 20000, Null, Null, Null));
        allCards[245] = new Card("Defender", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(NeedsDefence, Null, Null, Null, Null));
        allCards[246] = new Card("Dark Assassin", UndeadArmy, Ragnarok, 2, Card.composeKeyAttributes(NeedsDefence, Null, Null, Null, Null));
        allCards[247] = new Card("Witch", UndeadArmy, Ragnarok, 2, Card.composeKeyAttributes(Null, Null, Null, Null, Null));
        allCards[248] = new Card("Dark Wall", UndeadArmy, Ragnarok, 2, Card.composeKeyAttributes(IsABuilding, NeedsADarkBuilding + 10000, Null, Null, Null));
        allCards[249] = new Card("Dark Forge", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(IsABuilding, Null, Null, Null, Null));
        allCards[250] = new Card("Cursed Gold Factory", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(NeedsAGoldFactory + 10000, GivesGoldToken, NeedsGoldStorage + 20000, Null, Null));
        allCards[251] = new Card("Cursed Brewery", UndeadArmy, Ragnarok, 1, Card.composeKeyAttributes(NeedsBrewery + 100000, GivesBeerToken, NeedsBeerStorage + 200000, Null, Null));
        return allCards;
    }

    //----------{Building Randomization}----------------------------------------------------------------------------------------------------------------
    private static boolean SmartLevel1Buildings(short[] NeededPref){
        boolean returnValue = false;
        if(contains(NeededPref,StoreGold)){
            if(!contains(NeededPref,GivesGoldToken)){
                returnValue = true;
            }
        }
        if(contains(NeededPref,StoreBeer)){
            if(!contains(NeededPref,GivesBeerToken)){
                returnValue = true;
            }
        }
        return returnValue;
    }
    private static boolean SmartLevel2Buildings(short[] NeededPref){
        boolean Return = false;
        if(contains(NeededPref, NeedsBeerStorage)){
            if(!contains(NeededPref, StoreBeer)){
                Return = true;
            }
        }
        if(contains(NeededPref, NeedsGoldStorage)){
            if(!contains(NeededPref, StoreGold)){
                Return = true;
            }
        }
        return Return;
    }
    static Card[] getRandomBuilding(short numOfBuildings,short smartness, boolean[] expansions, boolean BrewAndFact){
        Card[] returnArray = new Card[numOfBuildings];
        boolean keepLooping = true;
        while(keepLooping){
            returnArray = getBuildingsArray(numOfBuildings, expansions);
            keepLooping = (isBuildingsSmart(returnArray,smartness) || hasNeededExpansions(returnArray, expansions));
            if(BrewAndFact){
                keepLooping = keepLooping || !(contains(returnArray,allCards[5])&&contains(returnArray,allCards[12]));
            }
        }
        return returnArray;
    }
    private static boolean isBuildingsSmart(Card[] buildings, short smartness){
        boolean returnValue = false;
        short[] NeededPref = NeededPref(buildings,smartness);
        if(smartness >= 1){
            returnValue = SmartLevel1Buildings(NeededPref);
        }
        if (smartness >= 2){
            returnValue = SmartLevel2Buildings(NeededPref) ||returnValue;
        }
        if(RandomizedFlying){
             returnValue = returnValue  || !contains(buildings, allCards[188]);
        }
        if(smartness >=3){
            if(!RandomizedFlying){
                returnValue = returnValue  || contains(buildings, allCards[188]);
            }
        }
        return  returnValue;

    }
    private static Card[] getBuildingsArray(short numOfBuildings, boolean[] expasions){
        Card[] returnArray = new Card[numOfBuildings];
        short random = (short) ((Math.random()*251)+1);
        short LoopCount = 0;
        Card[] currentCard = new Card[1];
        while(LoopCount <= numOfBuildings-1){
            if(allCards[random].TypeOfCard == Buildings){

                if(!(hasThisAttribute(allCards[random], IsForKickStarter) || hasThisAttribute(allCards[random], IsFor5Players))){
                    if(!contains(returnArray,allCards[random])){
                        currentCard[0] = allCards[random];
                        if(!hasNeededExpansions(currentCard, expasions)){
                            returnArray[LoopCount] = allCards[random];
                            LoopCount++;
                        }

                    }
                }
            }
            random = (short) ((Math.random()*251)+1);
        }

        return returnArray;

    }

    //----------{Defence Randomization}-----------------------------------------------------------------------------------------------------------------
    static Card[] getRandomDefences(short numOfDefences, short smartness, boolean[] expansions) {
        allCards = composeDecks();
        RandomizedFlying = false;
        Card[] returnArray = new Card[numOfDefences];
        short RandomNumber;
        short ArraySpot;
        do{
            ArraySpot = 0;
            if(smartness >= 2){
                if(RandomizedFlying2){
                    while (ArraySpot < numOfDefences-1) {
                        RandomNumber = (short) ((Math.random() * 251) + 1);
                        if (allCards[RandomNumber].TypeOfCard == Defences) {
                            if (!allCards[RandomNumber].Name.contains("(")) {
                                if (!contains(returnArray, allCards[RandomNumber])&& RandomNumber != 168) {
                                    returnArray[ArraySpot] = allCards[RandomNumber];
                                    ArraySpot++;
                                }
                            }
                        }
                    }


                    returnArray[2] = allCards[168];

                }else{
                    returnArray[0] = allCards[6];
                    returnArray[1] = allCards[7];
                    returnArray[2] = allCards[16];
                }
            }
            if(smartness >= 3) {
                if (!RandomizedFlying2) {
                    returnArray[0] = allCards[6];
                    returnArray[1] = allCards[7];
                    returnArray[2] = allCards[16];

                } else {
                    while (ArraySpot < numOfDefences - 1) {
                        RandomNumber = (short) ((Math.random() * 251) + 1);
                        if (allCards[RandomNumber].TypeOfCard == Defences) {
                            if (!allCards[RandomNumber].Name.contains("(")) {
                                if (!contains(returnArray, allCards[RandomNumber]) && RandomNumber != 168) {
                                    returnArray[ArraySpot] = allCards[RandomNumber];
                                    ArraySpot++;
                                }
                            }
                        }
                    }
                    returnArray[2] = allCards[168];
                }
            }
            if(smartness < 2){
                while (ArraySpot < numOfDefences) {
                    RandomNumber = (short) ((Math.random() * 251) + 1);
                    if (allCards[RandomNumber].TypeOfCard == Defences) {
                        if (!allCards[RandomNumber].Name.contains("(")) {
                            if (!contains(returnArray, allCards[RandomNumber])) {
                                returnArray[ArraySpot] = allCards[RandomNumber];
                                ArraySpot++;
                            }
                        }
                    }
                }
            }
        }while(hasNeededExpansions(returnArray, expansions));

        return returnArray;
    }

    //----------{Units}---------------------------------------------------------------------------------------------------------------------------------
    static Card[] getRandomUnits(short numOfUnits, short smartness, boolean[] expansions){
        allCards = composeDecks();
        RandomizedFlying = false;
        RandomizedFlying2 = false;
        Card[] returnArray = new Card[numOfUnits];
        short RandomNumber;
        short ArraySpot;
        do{
            ArraySpot = 0;
            do{
                RandomNumber = (short) ((Math.random()*251)+1);
                if(allCards[RandomNumber].TypeOfCard == Units){
                    if(!allCards[RandomNumber].Name.contains("(")){
                        if(!contains(returnArray,allCards[RandomNumber])){
                            returnArray[ArraySpot] = allCards[RandomNumber];
                            ArraySpot++;
                        }
                    }
                }
            }while (ArraySpot < numOfUnits );
        }while(hasNeededExpansions(returnArray, expansions));

        short[] NeededPref = NeededPref(returnArray, smartness);
        if(contains(NeededPref,NeedsWalls)){
            RandomizedFlying = true;
        }
        if(contains(NeededPref,Flying)){
            RandomizedFlying2 = true;
        }
        return returnArray;
    }

    //----------{End Game Bonuses}----------------------------------------------------------------------------------------------------------------------
    static Card[] getEndGameBonuses(short smartness, String GameMode, boolean[] expansions, Card[] Units, Card[] Buildings){
        Card[] returnArray;
        short[] NeededPref;
        do {
            if(GameMode.equals("Ragnarok")){
                returnArray = getObjective();
            }else{
                returnArray = getEndGame();
            }
            NeededPref = NeededPref(returnArray,smartness);
        }while(isEGBSmart(NeededPref,Buildings,Units)  || hasNeededExpansions(returnArray, expansions));
        return returnArray;
    }
    private static Card[] getObjective(){
        boolean Loop = true;
        short count = 0;
        Card[] Return = new Card[2];
        short RandomPick = (short) ((Math.random()*251)+1);
        while(Loop){
            if(allCards[RandomPick].TypeOfCard == EndGameBonuses && allCards[RandomPick].Expansion == Ragnarok){
                if(!contains(Return, allCards[RandomPick])){
                    Return[count] = allCards[RandomPick];
                    count++;
                }
            }
            RandomPick = (short) ((Math.random()*251)+1);
            Loop = count <= 1;
        }
        return Return;

    }
    private static Card[] getEndGame(){
        boolean Loop = true;
        short count = 0;
        Card[] Return = new Card[3];
        short RandomPick = (short) ((Math.random()*251)+1);
        while(Loop){
            if(allCards[RandomPick].TypeOfCard == EndGameBonuses && allCards[RandomPick].Expansion != Ragnarok){
                if(!contains(Return, allCards[RandomPick])){
                    Return[count] = allCards[RandomPick];
                    count++;
                }

            }
            RandomPick = (short) ((Math.random()*251)+1);
            Loop = count <= 2;
        }
        return Return;
    }
    private static boolean isEGBSmart(short[] NeededPref, Card[] Buildings, Card[] Units){
        if(contains(NeededPref,NeedsGoldStorage)){
            if(!contains(Buildings, allCards[11])){
                return true;
            }
        }
        if(contains(NeededPref,NeedsBeerStorage)){
            if(!contains(Buildings, allCards[2])){
                 return true;
            }
        }
        if(contains(NeededPref,NeedsPigator)){
            if(!contains(Units, allCards[15]) || !contains(Units,allCards[97])  || !contains(Units,allCards[203])){
                 return true;
            }
        }

        if(contains(NeededPref,NeedsBanshee)){
            if(!contains(Units, allCards[71])){
                 return true;
            }
        }
        if(contains(NeededPref,NeedsWallBreakers)){
            if(!contains(Units, allCards[164])){
                 return true;
            }
        }
        if(contains(NeededPref,NeedsWalls)){
            if(!contains(Buildings, allCards[188])){
                 return true;
            }
        }

        if(contains(NeededPref,NeedsFlying)){
            if(!RandomizedFlying2){
                return true;
            }
        }
        if(contains(NeededPref,NeedsMortarTurtles)){
            if(!contains(Units,allCards[70])){
                return true;
            }
        }
        return false;
    }

    //----------{Spells}--------------------------------------------------------------------------------------------------------------------------------
    static Card[] getSpells(short numOfSpells, boolean[] expansions){
        short RandomNumber;
        short ArraySpot;
        Card[] returnArray = new Card[numOfSpells];
        do{
            ArraySpot = 0;
            do{
                RandomNumber = (short) ((Math.random()*251)+1);
                if(allCards[RandomNumber].TypeOfCard == Spells){
                    if(!contains(returnArray,allCards[RandomNumber])){
                        returnArray[ArraySpot] = allCards[RandomNumber];
                        ArraySpot++;
                    }
                }
            }while (ArraySpot < numOfSpells );
        }while(hasNeededExpansions(returnArray, expansions));

        return returnArray;
    }

    //----------{Other Note}----------------------------------------------------------------------------------------------------------------------------
    static String getOtherNotes
    (Card[] Buildings, Card[] Units, Card[] Defences, int NumberOfPlayers,
     boolean HasKickStarter, boolean IsPlayingRagnorok, boolean IsPlayingGuildWars){
        StringBuilder ReturnArray = new StringBuilder();
        boolean FIRST = true;
        if(NumberOfPlayers == 5){
            String Fifth = "";
            if(contains(Buildings, allCards[2]) | contains(Buildings, allCards[17]) | contains(Buildings, allCards[11])
                    | contains(Buildings, allCards[12]) | contains(Buildings, allCards[8]) | contains(Buildings, allCards[5])
                    | containsName(Units, allCards[4]) | containsName(Units, allCards[10]) | containsName(Units, allCards[15])
                    | contains(Defences, allCards[6]) | contains(Defences, allCards[7]) | contains(Defences, allCards[6])){
                Fifth += "Add these 5th Player expansion cards:";
            }
            if(contains(Buildings,  allCards[2])){Fifth += "\n    Fifth Player Brewery";}
            if(contains(Buildings,  allCards[5])){Fifth += "\n    Fifth Player Beer Container";}
            if(containsName(Units,  allCards[4])){Fifth += "\n    Fifth Player Bone Crusher";}
            if(contains(Defences,   allCards[6])){Fifth += "\n    Fifth Player Cannon";}
            if(contains(Defences,   allCards[7])){Fifth += "\n    Fifth Player Chicken Tower";}
            if(contains(Buildings,  allCards[8])){Fifth += "\n    Fifth Player Drakkar";}
            if(containsName(Units, allCards[10])){Fifth += "\n    Fifth Player Elf Archer";}
            if(contains(Buildings, allCards[11])){Fifth += "\n    Fifth Player Gold Container";}
            if(contains(Buildings, allCards[12])){Fifth += "\n    Fifth Player Gold Factory";}
            if(containsName(Units, allCards[15])){Fifth += "\n    Fifth Player Pigator";}
            if(contains(Defences,  allCards[16])){Fifth += "\n    Fifth Player Sheep Cannon";}
            if(contains(Buildings, allCards[17])){Fifth += "\n    Fifth Player Tavern";}
            ReturnArray.append(Fifth);
            FIRST = false;
        }
        if(HasKickStarter){
            if(FIRST){
                if(contains(Defences, allCards[7]) | contains(Defences,allCards[16]) |
                containsName(Units, allCards[4]) | containsName(Units, allCards[10]) | containsName(Units, allCards[15])){
                    ReturnArray.append("Add these KickStarter expansion cards:");
                }
                if (containsName(Units, allCards[1])) {
                    ReturnArray.append("\n    KickStarter Bone Crusher");
                }
                if (contains(Defences, allCards[7])) {
                    ReturnArray.append("\n    KickStarter Chicken Tower");
                }
                if (containsName(Units, allCards[10])) {
                    ReturnArray.append("\n    KickStarter Elf Archer");
                }
                if (containsName(Units, allCards[15])) {
                    ReturnArray.append("\n    KickStarter Pigator");
                }
                if (contains(Defences, allCards[16])) {
                    ReturnArray.append("\n    KickStarter Sheep Cannon");
                }
            }else {
                if (contains(Defences, allCards[7]) | contains(Defences, allCards[16]) |
                        containsName(Units, allCards[4]) | containsName(Units, allCards[10]) | containsName(Units, allCards[15])) {
                    ReturnArray.append("\n\nAdd these KickStarter expansion cards:");
                }
                if (containsName(Units, allCards[1])) {
                    ReturnArray.append("\n    KickStarter Bone Crusher");
                }
                if (contains(Defences, allCards[7])) {
                    ReturnArray.append("\n    KickStarter Chicken Tower");
                }
                if (containsName(Units, allCards[10])) {
                    ReturnArray.append("\n    KickStarter Elf Archer");
                }
                if (containsName(Units, allCards[15])) {
                    ReturnArray.append("\n    KickStarter Pigator");
                }
                if (contains(Defences, allCards[16])) {
                    ReturnArray.append("\n    KickStarter Sheep Cannon");
                }
            }

        }
        if(IsPlayingRagnorok){
            ReturnArray.append("\n\nAdd these cards to the Undead Army Deck:");
            if(NumberOfPlayers == 1){
                ReturnArray.append("\n    18 Undead Army cards");
            }else if(NumberOfPlayers == 2){
                ReturnArray.append("\n    21 Undead Army cards");
            }else if(NumberOfPlayers == 3){
                ReturnArray.append("\n    24 Undead Army cards");
            }else if(NumberOfPlayers == 4) {
                ReturnArray.append("\n    28 Undead Army cards");
            }else{
                ReturnArray.append("\n    28 Undead Army cards");
            }
            ReturnArray.append("\n\nAdd one random boss to the bottom of the Undead Army Deck"
                    + "\n\nReveal 3 Undead Army cards\nPlace the Push Back card in the forth spot");
        }
        if(IsPlayingGuildWars){
            ReturnArray.append("\n\nDon't forget the Guild Tower.");
        }
        if(containsName(Units, allCards[153])){
            ReturnArray.append("\n\nDon't forget the Dreki Eggs.");
        }
        return ReturnArray.toString();
    }
    //----------{TOOLS}---------------------------------------------------------------------------------------------------------------------------------
    private static short[] NeededPref(Card[] arrayToCheck, short smartness){
        short[] neededPref = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        short arrayCount = 0;

        //-----{ IF HAS TAG 0}----------------------------------------------------------------------
        for(Card currentCard : arrayToCheck){
            for(short arraySlot : intToShortArray(currentCard.keyAttributes)){
                if(((short) Math.floor(arraySlot/10000) == 0) && arraySlot !=0) {
                    neededPref[arrayCount] = (short)(currentCard.keyAttributes[0] % 10000);
                    arrayCount++;
                }
            }
        }

        //-----{IF HAS TAG 1}-----------------------------------------------------------------------
        if(smartness >= 1){
            for(Card currentCard : arrayToCheck){
                for(short arraySlot : intToShortArray(currentCard.keyAttributes)){
                    if(((short) Math.floor(arraySlot/10000) == 1) && arraySlot != 0) {
                        neededPref[arrayCount] = (short)(arraySlot % 10000);
                        arrayCount++;
                    }
                }
            }
        }

        //-----{ IF HAS TAG 2}----------------------------------------------------------------------
        if(smartness >= 2){
            for(Card currentCard : arrayToCheck){
                for(short arraySlot : intToShortArray(currentCard.keyAttributes)){
                    if(((short) Math.floor(arraySlot/20000) == 1)&& arraySlot != 0) {
                        neededPref[arrayCount] = (short)(arraySlot % 20000);
                        arrayCount++;
                    }
                }
            }
        }

        //-----{ IF HAS TAG 3}----------------------------------------------------------------------
        if(smartness >= 3){
            for(Card currentCard : arrayToCheck){
                for(short arraySlot : intToShortArray(currentCard.keyAttributes)){
                    if(((short) Math.floor(arraySlot/30000) == 1)&& arraySlot != 0) {
                        neededPref[arrayCount] =(short)( arraySlot % 30000);
                        arrayCount++;
                    }
                }
            }
        }

        //-----{ IF HAS TAG 4}----------------------------------------------------------------------
        for(Card currentCard : arrayToCheck){
            for(short arraySlot : intToShortArray(currentCard.keyAttributes)){
                if(((short) Math.floor(arraySlot/40000) == 1)&& arraySlot != 0) {
                    neededPref[arrayCount] = (short)((arraySlot % 10000) + 400000000);
                    arrayCount++;
                }
            }
        }
        return  neededPref;
    }
    private static boolean hasThisAttribute(Card cardToRead, short WhatAttribute){
        short attribute = (short)(WhatAttribute%10000);
        if(cardToRead.keyAttributes[0]==attribute){
            return true;
        }else if(cardToRead.keyAttributes[1]==attribute){
            return true;
        }else if(cardToRead.keyAttributes[2]==attribute){
            return true;
        }else if(cardToRead.keyAttributes[3]==attribute){
            return true;
        }else if(cardToRead.keyAttributes[4]==attribute){
            return true;
        }
        return false;
    }
    private static boolean contains(short[] Array, short containsThis){
        for(short currentObject: Array){
            if(currentObject == containsThis){
                return true;
            }
        }
        return false;
    }
    private static boolean contains(Card[] Array, Card containsThis){
        for(Card currentObject: Array){
            if(currentObject == containsThis){
                return true;
            }
        }
        return false;
    }
    private static boolean hasNeededExpansions(Card[] CardsToCheck, boolean[] expansions) {
        short[] NeededExpansions = new short[CardsToCheck.length];
        short counter = 0;
        for (Card CurrentCards : CardsToCheck) {
            NeededExpansions[counter] = CurrentCards.Expansion;
            counter++;
        }
        if(contains(NeededExpansions, (short)201)){if(!expansions[0]){return true;}}
        if(contains(NeededExpansions, (short)203)){if(!expansions[1]){return true;}}
        if(contains(NeededExpansions,(short) 202)){if(!expansions[2]){return true;}}
        if(contains(NeededExpansions, (short)204)){if(!expansions[3]){return true;}}
        if(contains(NeededExpansions, (short)205)){if(!expansions[4]){return true;}}
        if(contains(NeededExpansions, (short)206)){if(!expansions[5]){return true;}}

        return false;
    }
    private static short[] intToShortArray(int[] toConvert){
        short[] Return = new short[toConvert.length];
        short counter = 0;
        for(int currentNumber : toConvert){
            Return[counter] = ((short) currentNumber);
            counter++;
        }
        return Return;
    }
    private static boolean containsName(Card[] ArrayToCheck, Card CardToFind){
        for(Card CurrentCard : ArrayToCheck){
            if(CurrentCard.Name.equals(CardToFind.Name)){
                return true;
            }
        }
        return false;
    }

}

