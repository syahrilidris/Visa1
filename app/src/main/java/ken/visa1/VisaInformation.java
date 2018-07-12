package ken.visa1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class VisaInformation extends AppCompatActivity {
    private final String htmlText = "<b><font face=\"Arial\" size=\"2\" color=\"#FFFFFF\">\n" +
            "        <span style=\"background-color: #000000\">&nbsp; VISA&nbsp; INFORMATION&nbsp;\n" +
            "        </span></font></b>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">Every person entering \n" +
            "        Malaysia must possess a valid National Passport or Internationally \n" +
            "        recognized Travel Document valid for travel to Malaysia. Any person not \n" +
            "        in possession of a Passport or Travel Document which is recognized by \n" +
            "        Malaysian Government, must obtain a Document in lieu of Passport. \n" +
            "        Application for the Document in lieu of Passport can be made at any \n" +
            "        Malaysian Representative Office abroad. Holders of Travel Documents like \n" +
            "        a Certificate of Identity, Laisser Passer, Titre de Voyage or a \n" +
            "        Country's Certificate of Permanent Residence must ensure that their \n" +
            "        return to the country which issued the document or the country of \n" +
            "        residence is guaranteed. The documents shall be valid, for more than six \n" +
            "        (6) months from the date of entry into Malaysia.</font></p>\n" +
            "        <p><b><font face=\"Arial\" size=\"2\" color=\"#575757\">Visa Requirement :-</font></b></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">Foreign nationals who \n" +
            "        require a Visa to enter Malaysia must apply and obtain a Visa in advance \n" +
            "        at Malaysian Representative Office before entering the country. A visa \n" +
            "        is an endorsement in a passport or other recognized travel document of \n" +
            "        foreigner indicating that the holder has applied for permission to enter \n" +
            "        Malaysia and that permission has been granted. Foreign nationals who \n" +
            "        require a Visa to enter Malaysia must apply and obtain a Visa in advance \n" +
            "        at any Malaysian Representative Office abroad before entering the \n" +
            "        country. Visa, which has been granted is not absolute guarantee that the \n" +
            "        holder will be allowed to enter Malaysia.The final decision lies with \n" +
            "        the Immigration Officer at the entry point.</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\"><b>\n" +
            "        <a name=\"Types of Visa\">Types of Visa</a></b><br>\n" +
            "        Three (3) types of visa are issued by the Malaysian Government to \n" +
            "        foreign national:<br>\n" +
            "        <br>\n" +
            "        * Single Entry Visa<br>\n" +
            "        Issued to foreign nationals who require a visa to enter Malaysia mainly \n" +
            "        for a social or business visit. Normally valid for a single entry and \n" +
            "        for a period of three (3) months from the date of issue. <br>\n" +
            "        <br>\n" +
            "        * Multiple Entry Visa <br>\n" +
            "        Issued to foreign nationals who require a visa to enter Malaysia mainly \n" +
            "        for business or government to government matters. Normally valid for a \n" +
            "        period within three (3) to twelve (12) months from the date of issue.\n" +
            "        <br>\n" +
            "        <br>\n" +
            "        * Transit Visa<br>\n" +
            "        Issued to foreign nationals who require a visa to enter Malaysia on \n" +
            "        transit to other countries. Foreign Nationals on transit without leaving \n" +
            "        the airport precincts and who continue their journey to the next \n" +
            "        destination with the same flight does not require a transit visa. <br>\n" +
            "        <br>\n" +
            "        <b>How To Apply For A Visa</b><br>\n" +
            "        Application for visas should be made at the nearest Malaysian Missions \n" +
            "        abroad. In countries where Malaysian Missions have not been established, \n" +
            "        application should be made to the British High Commission or Embassy. \n" +
            "        The applicant should present himself together with the following \n" +
            "        documents:<br>\n" +
            "        (a) Passport or Travel Document <br>\n" +
            "        (b) Form IM.47 (3 copies)<br>\n" +
            "        (c) Three (3) passport sized photographs<br>\n" +
            "        (d) Return or onward - journey traveling ticket<br>\n" +
            "        (e) Proof of sufficient funds<br>\n" +
            "&nbsp;</font></p>\n" +
            "        <p><b><font face=\"Arial\" size=\"2\" color=\"#575757\">\n" +
            "        <a name=\"VISA REQUIREMENT\">VISA REQUIREMENT</a></font></b></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">1. Nationals of the \n" +
            "        following countries DO NOT REQUIRE VISA for Social Visit. The duration \n" +
            "        of stay is 3 Months only. The countries are : </font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">ALBANIA, ALGERIA, \n" +
            "        ARGENTINA, AUSTRALIA, AUSTRIA, BAHRAIN, BELGIUM, BOSNIA HERZEGOVINA, \n" +
            "        BRAZIL, CANADA, CROATIA, CUBA, CZECH REPUBLIC, DENMARK, EGYPT, FINLAND, \n" +
            "        FRANCE, GERMANY, HUNGARY, ICELAND, ITALY, JAPAN, JORDAN, KIRGYSTAN, \n" +
            "        KUWAIT, KYRGYZ REPUBLIC, LEBANON, LIECHTENSTEIN, LUXEMBOURG, MOROCCO, \n" +
            "        NETHERLAND, NEW ZEALAND, NORTH YEMEN, NORWAY, OMAN, PERU, POLAND, QATAR, \n" +
            "        ROMANIA, ST. MARINO, SAUDI ARABIA, SLOVAKIA, SOUTH AFRICA, SOUTH KOREA, \n" +
            "        SPAIN, SWEDEN, SWITZERLAND, TUNISIA, TURKMENISTAN, TURKEY, U.S.A, U.A.E, \n" +
            "        UNITED KINGDOM, URUGUAY.</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">2. Nationals of the \n" +
            "        following countries DO NOT require a visa to enter Malaysia For Social \n" +
            "        Visit and the duration of stay is 1 Month only. The countries are :\n" +
            "        </font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">All ASEAN countries \n" +
            "        except: MYANMAR, ANTIGUA &amp; BERMUDA, ARMENIA, AZERBAIJAN, BAHAMAS, \n" +
            "        BARBADOS, BELARUS, BELIZE, BENIN, BHUTAN, BOLIVIA, BOTSWANA, BULGARIA, \n" +
            "        CAMBODIA, CHILE, COLOMBIA, COSTA RICA, CYPRUS, DOMINICA, ECUADOR, EL \n" +
            "        SALVADOR, ESTONIA, FIJI, GABON, GAMBIA, GEORGIA, GHANA, GREECE, GRENADA, \n" +
            "        GUATEMALA, GUYANA, HAITI, HONDURAS, HONG KONG (SAR), IVORY COAST, \n" +
            "        JAMAICA, KAZAKHSTAN, KENYA, KIRIBATI, LATVIA, LESOTHO, LITHUANIA, MACAU \n" +
            "        (SAR), MACEDONIA, MALAWI, MALDIVES, MALDOVA, MALTA, MAURITIUS, MEXICO, \n" +
            "        MOLDAVIA, MONACO, MONGOLIA, NAMIBIA, NAURU, NICARAGUA, NORTH KOREA, \n" +
            "        PENAMA, PAPUA NEW GUINEA, PARAGUAY, PORTUGAL, RUSSIA, SAO TOME &amp; \n" +
            "        PRINCIPE, SLOVENIA, SOLOMAN ISLAND, ST. KITTS &amp; NEVIS, ST. LUCIDA, ST. \n" +
            "        VINCENT, SUDAN, SURINAM, SWAZILAND, TAJIKISTAN, TANZANIA, TOGO, TRINIDAD \n" +
            "        &amp; TOBAGO, TUVALU, UGANDA, UKRAINE, UPPER VOLTA, UZBEKISTAN, VANUATU, \n" +
            "        VATICAN CITY, VENEZUELA, WESTERN SAMOA, ZAIRE, ZAMBIA, AND ZIMBABWE.</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">3. Nationals of the \n" +
            "        following countries DO NOT require a visa to enter Malaysia For Social \n" +
            "        Visit and the duration of stay is 14 days only. The countries are :\n" +
            "        </font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">IRAQ, LIBYA, SYRIA, MACAU \n" +
            "        (TRAVEL PERMIT), PORTUGAL (ALIEN PASSPORT), PALESTINE, SIERRA LEONE, \n" +
            "        SOMALI, SOUTH YEMEN.</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">4. Nationals of the \n" +
            "        following countries DO NOT require a visa to enter Malaysia For Social \n" +
            "        Visit and the duration of stay is 15 days only. The country is : IRAN\n" +
            "        </font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">5. Nationals of the \n" +
            "        following countries DO NOT require a visa to enter Malaysia For Any \n" +
            "        Purpose of Visit. The countries are : </font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">All Commonwealth \n" +
            "        Countries except: INDIA, PAKISTAN, BANGLADESH, SRI LANKA AND NIGERIA.</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">6. Nationals of the \n" +
            "        following countries REQUIRE a visa to enter Malaysia For Any Purpose of \n" +
            "        Visit. The countries are : </font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">Sub Continent Nationals: \n" +
            "        BANGLADESH, INDIA, PAKISTAN, SRI LANKA.</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">African Countries: \n" +
            "        ANGOLA, BURKINA FASO, BURUNDI, CAMEROON, CENTRAL AFRICAN REPUBLIC, CONGO \n" +
            "        REPUBLIC, CONGO DEMOCRATIC REPUBLIC, COTE D'IVOIRE, DJIBOUTI, EQUATORIAL \n" +
            "        GUINEA, ERITREA, ETHIOPIA, GUINEA-BISSAU, GHANA, LIBERIA, MALI, \n" +
            "        MOZAMBIQUE, NIGER, NIGERIA, RWANDA, WESTERN SAHARA.</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">Other Countries: TAIWAN, \n" +
            "        MYANMAR, NEPAL, BHUTAN, PR CHINA.</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">All holders Certificate \n" +
            "        of Identity, All holders of Laisser Passer, All holders of Titre De \n" +
            "        Voyage, Afghanistan (Visa With Reference)</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">7. Nationals of the \n" +
            "        following countries DO NOT require a visa to enter Malaysia For Social \n" +
            "        Visit &amp; Study. The countriy is : UNITED STATES OF AMERICA (USA)</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\"><b>\n" +
            "        <a name=\"VISA ON ARRIVAL\">VISA ON ARRIVAL</a></b></font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">Visa-on-arrival will be \n" +
            "        given only to foreign nationals who already have a visa to enter \n" +
            "        Singapore or Thailand.<br>\n" +
            "        However, the following conditions apply:</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">1. The visa will be \n" +
            "        specifically for tourist purposes only and is valid for a duration \n" +
            "        period of 14 days. Extension of visa is NOT allowed. <br>\n" +
            "        2. Must have a confirmed return ticket AND <br>\n" +
            "        3. Point of entry is<br>\n" +
            "        a) The Kuala Lumpur International Airport OR<br>\n" +
            "        b) The Sultan Abu Bakar Complexs, Tanjung Kupang.</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">However, nationals from \n" +
            "        the following African countries are NOT entitled to apply for \"visa on \n" +
            "        arrival\" :</font></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">1. ANGOLA 12. ETHIOPIA\n" +
            "        <br>\n" +
            "        2. BURKINA FASO 13. GUINEA-BISSAU <br>\n" +
            "        3. BURUNDI 14. GHANA <br>\n" +
            "        4. CAMEROON 15. LIBERIA <br>\n" +
            "        5. CENTRAL AFRICAN REPUBLIC 16. MALI <br>\n" +
            "        6. CONGO REPUBLIC 17. MOZAMBIQUE <br>\n" +
            "        7. DEMOCRATIC CONGO REPUBLIC 18. NIGER <br>\n" +
            "        8. COTE D'IVORE 19. NIGERIA <br>\n" +
            "        9. DJIBOUTI 20. RWANDA <br>\n" +
            "        10. EQUATORIAL GUINEA 21. WESTERN SAHARA <br>\n" +
            "        11. ERITREA </font></p>\n" +
            "        <p><b><font face=\"Arial\" size=\"2\" color=\"#575757\">\n" +
            "        <a name=\"CUSTOMS FORMALITIES\">CUSTOMS FORMALITIES</a></font></b></p>\n" +
            "        <p><font face=\"Arial\" size=\"2\" color=\"#575757\">Dutiable and Non-Dutiable \n" +
            "        Goods<br>\n" +
            "        Certain goods such as the following, imported by visitors are liable to \n" +
            "        duty: carpets, garments, clothing accessories, jewellery, chocolates, \n" +
            "        handbags, spirits, alcoholic beverages, tobacco and cigarettes. Visitors \n" +
            "        bringing in dutiable goods may have to pay a deposit for temporary \n" +
            "        importation, refundable on departure. The goods are to be presented at \n" +
            "        the time of departure at the point of exit together with the deposit \n" +
            "        receipts. Non-dutiable goods include cameras, watches, pens, lighters, \n" +
            "        perfumeries and cosmetics.</font></p>\n" +
            "        <p align=\"center\"><font face=\"Arial\" color=\"#000000\" size=\"-1\">\n" +
            "        <font face=\"Arial\" color=\"#ff3300\" size=\"-1\"><b>::</b> </font>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regulation);
        TextView htmlTextView = (TextView)findViewById(R.id.visaInfo);
        htmlTextView.setText(Html.fromHtml(htmlText));

    }

}
