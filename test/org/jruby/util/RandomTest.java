package org.jruby.util;

import junit.framework.TestCase;

public class RandomTest extends TestCase {

    /*
     * 0.upto(20).each do |idx|
     *   mt = Random.new(idx)
     *   puts '{' + 10.times.map {
     *     v = mt.rand(0xffffffff)
     *     v[31] == 1 ? -(~v & 0x7fffffff) - 1 : v
     *   }.join(", ") + '},'
     * end
     */
    int[][] MT_SEQUENCE = new int[][] {
        {-1937831252, -1748719057, -1223252363, -668873536, -1706118333, -610118917, -1954711869, -656048793, 1819583497, -1616781613},
        {1791095845, -12091157, -1201197172, -289663928, 491263, 550290313, 1298508491, -4120955, 630311759, 1013994432},
        {1872583848, 794921487, 111352301, -294029752, -1934184938, -224495317, 1869695442, 2081981515, 1805465960, 1376693511},
        {-1929308310, 303761048, -1253495559, -687413629, 1249426360, 521102280, -2100979456, -1849793771, -459789315, 1877166739},
        {-141605766, -426827602, -1944622665, 741720773, -117319807, -620103320, -1224855977, -1679179320, -1298244814, -1728482935},
        {953453411, 236996814, -555200529, -724441411, 887852006, 1562238070, -349563504, -88283063, 2097710088, 385778404},
        {-460162166, -225588535, 1425842403, 899393492, -767815062, 275971437, 179085647, 1589607786, 462381904, -64300738},
        {327741615, 976413892, -945241575, 1369975286, 1882953283, -93531949, -1187708009, 1956722279, -94534308, 1322904761},
        {-543616573, 47736148, -135116815, 1028385129, -561805179, 1621423066, -2014959480, -788292781, 999560552, 1813982911},
        {44556670, 1565348188, -2139432322, 2143748597, 2129330102, 32397368, 574793467, 1358173078, 610362493, 57217601},
        {-982170359, 1283169405, 89128932, 2124247567, -1573468864, 1902734705, -1078879109, -721935204, 2141071321, -1789619491},
        {774252441, 293375679, 83645520, -1440015269, 1989508433, 833720247, -1181399795, -316612276, 1804760737, 451723847},
        {662124363, 1916507803, -1116478074, -543798019, 1130929393, 371232386, -2002574077, -1187121213, 62598988, 1505292720},
        {-954760878, -1686456144, 1020231754, -603726320, -754717978, -459635870, -147106060, 769458329, -117677332, -1036873798},
        {-2087597461, -335465128, -974248692, -1464219242, -556508857, 1573170937, 34561382, 639972074, 1330305692, 864515722},
        {-649323064, -800665867, 768352140, -1755116923, 233488247, 476682624, 1552795804, -779056485, 1182837959, -315066677},
        {959027881, 1402977518, -2047997831, 239174213, -1929722559, 1325499003, 195858884, 597836157, 1549318559, -1269316860},
        {1265576559, 780729585, -2016114545, -669010554, 822575510, -477321927, 291629808, -829696083, -914890474, 1761895455},
        {-1501631190, 326463763, -2124061576, 1858112325, -521402690, 1050329009, 780997806, -393525006, -634654142, 876054792},
        {418903645, 1848846958, -1025424651, 1772717410, 1060590504, -1222736877, 593271092, 1107576138, 1423552159, -1393147070},
        {-1768964765, -483563046, -439316209, -195797793, -465871972, -204964646, -790972023, -1625692780, 154144587, -1544661226},
    };
    
    public void testSequence() {
        for (int i = 0; i < MT_SEQUENCE.length; ++i) {
            Random mt = new Random(i);
            for (int j = 0; j < MT_SEQUENCE[i].length; ++j) {
                assertEquals(MT_SEQUENCE[i][j], mt.genrandInt32());
            }
        }
    }
}