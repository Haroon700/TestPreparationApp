package com.a1techandroid.test_preperation_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.a1techandroid.test_preperation_app.Custom.Question;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    DatabaseReference myRef;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        saveData1();
//        saveData2();
//        saveData3();
//        testForGEt();
//        saveData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(currentUser != null){
                    Intent i = new Intent(SplashActivity.this, MainActivityNew.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }else {
                    Intent i = new Intent(SplashActivity.this, LoginActivty.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }

            }
        }, 4000);
    }

    public void testForGEt(){
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(17, "the most devastating migratory pest is","Cutworm","Army worm","Locust","None of the above", "None of the above"));
        questions.add(new Question(18, "The Shahid Afridi Foundation together with___________distributed winter clothing to underprivileged people of Balochistan on 1st Feb 2019","Pakistan Airforce   ","Pakistan Army","Pakistan Navy","Pakistan Coast Guards", "Pakistan Airforce"));
        questions.add(new Question(19, "Which of the following famous personality of Pakistan visited Pakistan cricket team’s dressing room in S.Africa on 1st Feb 2019","Ex-CJP Mian Saqib Nisar","Army chief General Bajwa","Foreign minister Shah Mehmood Qureshi","Ex-President Perveez Musharaf", "Ex-President Perveez Musharaf"));
        questions.add(new Question(20, "Which of the following methods of tunneling is used for long tunnels at great depths","Army method","Needle beam method","Austrian method","English method  ", "Austrian method"));
        questions.add(new Question(33, "In which year Japan attacked Manchuria","1930","1931","1936","1937", "clear answer"));
        questions.add(new Question(34, "Who was behind the Karachi Stock Exchange attack on 29th June 2020","Balochistan Liberation Army","Tehrik E Taliban Pakistan","RAW","Balochistan Liberation Front", "Balochistan Liberation Front"));
        questions.add(new Question(35, "The developers of which country has developed the world’s 1st digital contact tracing app utilizing the Exposure Notification API of Apple and Google","United States","Switzerland ","Germany","Italy", "Germany"));
        questions.add(new Question(36, "‘Quwwat ul-Islam’ Mosque is in","Kabul","Agra","Lahore","Delhi", "Delhi"));

        questions.add(new Question(25, "Chief Election Commissioner Sikandar Sultan Raja was a","Retired Justice","Retired Civil Bureaucrat","Retired Army Officer","None of these", "Retired Army Officer"));
        questions.add(new Question(26, "The Third Battle of Panipat was fought between","Ahmad Shah Abdali and Marathas","Babur and Ibrahim Lodi","Akbar and Lal Singh","Ahmed Shah and Balaji Baji Rao", "Akbar and Lal Singh"));
        questions.add(new Question(28, "The Battle of Hattin was fight in ","1178","1187","1189","1200", "1189"));
        questions.add(new Question(29, "Battle of Hastings was fought in","1065","1066","1067","1068", "1068"));
        questions.add(new Question(30, "Who is the current Director General Military Intelligence (MI) of Pakistan","Major General Sarfraz Sattar","Major General Syed Asim Munir Ahmed","Major General Azhar Waqas","Major General Zeeshan Asghar", "Major General Sarfraz Sattar"));

        questions.add(new Question(21, "According to the article 45 of constitution, who possess the constitutional right to pardon a death row defendant ","Chief Justice of Pakistan","Chief of Army Staff of Pakistan","President of Pakistan","Prime Minister of Pakistan", "Chief of Army Staff of Pakistan"));
        questions.add(new Question(22, "How many Urdu Words are used in the National Anthem of Pakistan","5","2","1","2", "2"));
        questions.add(new Question(23, "The Battle of Yarmouk was fought during the caliphate o","Hazrat Abu Bakar (RA)","Hazrat Usman (RA)","Hazrat Umar (RA)","Hazrat Ali (RA)", "Hazrat Abu Bakar (RA)"));
        questions.add(new Question(24, "Who abolished Khilafat in Turkey","Alliance","British Army","Mustafa Kemal Atatürk","None of These", "None of These"));


        questions.add(new Question(31, "Who punished Musa bin Nusayr for invading Spain","Hajj Bin Yousuf","Walid Bin Abdul-Malik","Umar bin Abdul Aziz","Sulaiman", "Hajj Bin Yousuf"));
        questions.add(new Question(32, "Battale of ZALAQA was fought between Alfanso VI and Yousaf bin Tashfeen in ","1070","1086","1121","1240", "1121"));
       questions.add(new Question(37, "Which Country has successful conducted a test-flight of a Hypersonic Missile after Russia","USA","North Korea","France","Israel", "USA"));
        questions.add(new Question(1, "If a member of ASF deserts, who will be requested to capture the deserter","Civil authorities","Hataf","Abdali","Shaheen", "Shaheen"));
        questions.add(new Question(2, "Officers and members of ASF to be subject to the ","Civil Servant Rule, 1973","Police Order, 2002","Code of Criminal Procedure, 1898","Pakistan Army Act, 1952", "Code of Criminal Procedure"));
        questions.add(new Question(3, "According to ASF Act 1975, who is head of the Airports Security Force (ASF)"," Force Commander","Director General","Army Chief","Prime Minister", "Force Commander"));
        questions.add(new Question(4, "According to ASF Act 1975, the head of the Airports Security Force (ASF) shall be appointed by the","Prime Minister","Army Chief","Director General","Federal Government", "Director General"));
        questions.add(new Question(5, "Who has been named as India’s first Chief of Defence Staff?","Bikram Singh","Bipin Rawat","VK Singh","Deepak Kapoor", "VK Singh"));
        questions.add(new Question(6, "Article 58(2b) of constitution 1973 is about","Power of President to dismiss Army Chief","Power of President to dissolve Provincial Assemblies","Power of President to dissolve National Assembly","Power of President to dissolve Senate", "Power of President to dissolve Provincial Assemblies"));
        questions.add(new Question(7, "How many U.S. states border the Pacific Ocean","Four","Three","Five","Seven", "Four"));
        questions.add(new Question(8, "Mojave Desert desert is located in","Afghanistan","India","Australia","USA", "India"));
        questions.add(new Question(9, "The creator of the popular numbers puzzle Sudoku","Maki Kaji","Shinzo Teng","Mami Suzuki","Hiroko Akutsu", "Shinzo Teng"));
        questions.add(new Question(10, "What is the new name of the island of Madagascar","Haitti","Malagasy","Mozambique","Maputo", "Maputo"));

        questions.add(new Question(11, "Chief of which Armed Force has been awarded Highest Military Award of US armed forces in March 2018 (US legion of merit","Pak Air Force","Pak Army","Pak Navy","Indian Army", "Pak Army"));
        questions.add(new Question(12, "Who recently conferred with King Abdul Aziz Medal of Excellence (Highest Military Award of Saudi Arabia)?","Chief of Army Staff Qamar Bajwa","Ex Chief Admiral Muhammad Zakaullah","Admiral Zafar Abbasi","Air Chief Marshal Sohail Aman", "Admiral Zafar Abbasi"));
        questions.add(new Question(13, "Who hoisted the largest national flag in the history of Pakistan at Wagah Border on the eve of Pakistan’s 70th anniversary?","Chief Minister Shehbaz Sharif","President Mamnoon Hussain","Prime Minister Shahid Khaqan Abbasi","Chief of Army Staff General Qamar Javed Bajwa", "President Mamnoon Hussain"));
        questions.add(new Question(14, "PAKISTAN 9th International Defense Exhibition and Seminar to be held on 22-25 November-2016 in Karachi Expo Center, its name?","Defense Production Workshop-2016","Army Arms Ideas-2016","IDEAS-2016","IDEAS-2016", "IDEAS-2016"));
        questions.add(new Question(15, "22nd Amendment in 1973 Constitution of Pakistan is related to","Pak Army Trail Courts","Powers of Election Commission Members","Related to NRO"," Not made yet", "Related to NRO"));
        questions.add(new Question(16, "After Hijrat to madina, what first important thing Holy prophet (SAW) did","Built a mosque for prayers  ","Built his house","Created baitulmal","Raised an Army", "Created baitulmal"));


        //        questions.add(new Question(38, "","","","","", "clear answer"));
//        questions.add(new Question(39, "","","","","", "clear answer"));
//        questions.add(new Question(40, "","","","","", "clear answer"));
        myRef = database.getReference("Quiz2");
        myRef.setValue(questions);

    }

    public void saveData(){
        ArrayList<Question> questions = new ArrayList<>();
        myRef = database.getReference("Quiz");

        questions.add(new Question(31, "Under section 2(a) of the Anti-Terrorism Act, 1997 “Armed Forces” means","Army","Air Force","Navel and Reserves Forces","All of above", "clear answer"));
        questions.add(new Question(32, "Sections 131 to 140, P.P.C. are related to ","Railway, Post, Medical","Army, Media, Air Force","Army, Navy, Air Force","None of these", "clear answer"));
        questions.add(new Question(33, "Chief Election Commissioner before entering office shall make oath before","Chief Justice of Pakistan","President"," Chief of army staff","None of above", "clear answer"));
        questions.add(new Question(34, "National Command Authority (NCA) is headed by","Prime Minister","President","Army chief","Ministry For Defense", "clear answer"));
        questions.add(new Question(35, "Which one of the following","Aphids","Cut worm","Army worms","Weevils", "clear answer"));
        questions.add(new Question(36, "Shaheen-I SSBM is capable of delivering all types of warheads up to a range of","250km","450km","650km","850km", "clear answer"));
        questions.add(new Question(37, "Recently _________diplomats visited LoC areas affected by Indian shelling","20","22","23","24", "clear answer"));
        questions.add(new Question(38, "When was the Historic Quaid-i-Azam Ziarat Residency was set alight in an arson attack by militants?"," June 15, 2013","June 15, 2014","June 15, 2015","June 15, 2016", "clear answer"));
        questions.add(new Question(39, "COAS General Qamar Javed Bajwa was set to retire on","29 November 2019","25 August 2019","29 August 2019","NOne of these", "clear answer"));
        questions.add(new Question(40, "In order for power to be legitimate a government must have"," the ability to coerce agreement","legitimate authority","a charismatic leader","a strong army  ", "clear answer"));

        questions.add(new Question(21, "Which one of the following tunnelling methods is used for laying under ground sewers","Needle beam method","Army method","German method","Italian method", "clear answer"));
        questions.add(new Question(22, "Terror attack on Chinese Consulate that was carried out on 23rd November 2018 is claimed by","TTP","Baloch liberation army","Sindhudesh Liberation Army","Baluch Liberation Front", "clear answer"));
        questions.add(new Question(23, "Salutation : Farewell ::","Birth: Death","Army: Navy","Noon: Midnight","Lunch: Dinner", "clear answer"));
        questions.add(new Question(24, "Pakistan hosted an international marathon on 30th August 2018. The event was organized by _______ in collaboration with international marathon Travel Company, Z Adventures, and Serena Hotels","Pakistan army","PAF","Pakistan navy","CAA", "clear answer"));
        questions.add(new Question(25, "NA stands for","National Army","National Academy","National Assembly","National Assets", "clear answer"));
        questions.add(new Question(26, "Othello was sent to fight with_","French army","German army","Ottomans"," None of above", "clear answer"));
        questions.add(new Question(27, "According to the classical economists, the only gainers from growth would be"," landlords","peasants","The army","politicians", "clear answer"));
        questions.add(new Question(28, "Section 550, Cr.P.C. empower _________ to seize suspected property","Police","Magistrate","Army","None of above", "clear answer"));
        questions.add(new Question(29, "As per OrderV, Rule 28, of C.P.C. where the defendant is a soldier, sailor or airmen the Court shall send the summons for service to","Chief of Staff Committee","Chief of Air Staff, Navel or Army","Commanding Officer together with a copy to be retained by the defendants","None of the these", "clear answer"));
        questions.add(new Question(30, "Section 5(1) of the Anti-Terrorism Act, 1997 empower an officer of armed forces and civil armed forces with power of ","Police under the Code","Army under the Code","Both (a) and (b)","None of above", "clear answer"));

        questions.add(new Question(11, "Chief of which Armed Force has been awarded Highest Military Award of US armed forces in March 2018 (US legion of merit","Pak Air Force","Pak Army","Pak Navy","Indian Army", "clear answer"));
        questions.add(new Question(12, "Who recently conferred with King Abdul Aziz Medal of Excellence (Highest Military Award of Saudi Arabia)?","Chief of Army Staff Qamar Bajwa","Ex Chief Admiral Muhammad Zakaullah","Admiral Zafar Abbasi","Air Chief Marshal Sohail Aman", "clear answer"));
        questions.add(new Question(13, "Who hoisted the largest national flag in the history of Pakistan at Wagah Border on the eve of Pakistan’s 70th anniversary?","Chief Minister Shehbaz Sharif","President Mamnoon Hussain","Prime Minister Shahid Khaqan Abbasi","Chief of Army Staff General Qamar Javed Bajwa", "clear answer"));
        questions.add(new Question(14, "PAKISTAN 9th International Defense Exhibition and Seminar to be held on 22-25 November-2016 in Karachi Expo Center, its name?","Defense Production Workshop-2016","Army Arms Ideas-2016","IDEAS-2016","IDEAS-2016", "clear answer"));
        questions.add(new Question(15, "22nd Amendment in 1973 Constitution of Pakistan is related to","Pak Army Trail Courts","Powers of Election Commission Members","Related to NRO"," Not made yet", "clear answer"));
        questions.add(new Question(16, "After Hijrat to madina, what first important thing Holy prophet (SAW) did","Built a mosque for prayers  ","Built his house","Created baitulmal","Raised an Army", "clear answer"));
        questions.add(new Question(17, "the most devastating migratory pest is","Cutworm","Army worm","Locust","None of the above", "clear answer"));
        questions.add(new Question(18, "The Shahid Afridi Foundation together with___________distributed winter clothing to underprivileged people of Balochistan on 1st Feb 2019","Pakistan Airforce   ","Pakistan Army","Pakistan Navy","Pakistan Coast Guards", "clear answer"));
        questions.add(new Question(19, "Which of the following famous personality of Pakistan visited Pakistan cricket team’s dressing room in S.Africa on 1st Feb 2019","Ex-CJP Mian Saqib Nisar","Army chief General Bajwa","Foreign minister Shah Mehmood Qureshi","Ex-President Perveez Musharaf", "clear answer"));
        questions.add(new Question(20, "Which of the following methods of tunneling is used for long tunnels at great depths","Army method","Needle beam method","Austrian method","English method  ", "clear answer"));

        questions.add(new Question(1, "The latest version of Hatf-5 is","Ghauri-1","Hataf","Abdali","Shaheen", "clear answer"));
        questions.add(new Question(2, "Zafar Ahmed Chaudhry was the first Chief of Air Staff of ","Pak Army","Air Force","Navy","None of them", "clear answer"));
        questions.add(new Question(3, "Frank Meseri was the first C-in-C of"," Pak Army","Air Force","Navy","None of them", "clear answer"));
        questions.add(new Question(4, "Urdu is a word of Turkish language, it means","IWth","Arms","Army","Literature", "clear answer"));
        questions.add(new Question(5, "The Supreme commander of Pakistan Armed Forces is?","Army Chief","Prime Minister","President","Governor", "clear answer"));
        questions.add(new Question(6, "Article 58(2b) of constitution 1973 is about","Power of President to dismiss Army Chief","Power of President to dissolve Provincial Assemblies","Power of President to dissolve National Assembly","Power of President to dissolve Senate", "clear answer"));
        questions.add(new Question(7, "How many U.S. states border the Pacific Ocean","Four","Three","Five","Seven", "clear answer"));
        questions.add(new Question(8, "Mojave Desert desert is located in","Afghanistan","India","Australia","USA", "clear answer"));
        questions.add(new Question(9, "The creator of the popular numbers puzzle Sudoku","Maki Kaji","Shinzo Teng","Mami Suzuki","Hiroko Akutsu", "clear answer"));
        questions.add(new Question(10, "What is the new name of the island of Madagascar","Haitti","Malagasy","Mozambique","Maputo", "clear answer"));


//        myRef.setValue("hello");
        myRef.push().setValue(questions).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void aVoid) {
                Toasty.success(getApplicationContext(), "Saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toasty.error(getApplicationContext(), "failed");
            }
        });
    }

    public void saveData1(){
        ArrayList<Question> questions = new ArrayList<>();
        myRef = database.getReference("Question").child("Hard");

        questions.add(new Question( "In which year Japan attacked Manchuria", "1931"));

        questions.add(new Question( "In which of the following city Army Medical College is located", "Rawalpindi"));
        questions.add(new Question( "Tell the name of Chief of Staff of Pak Army who died in uniform", "A & B"));
        questions.add(new Question( "At the time of Kargil in 1999 the Chief of Army Staff was", " General Parvez Musharaf"));
        questions.add(new Question( "At the time of 1971 War the C-in-C of Pak Army was", "General Agha Muhammad Yahya Khan"));
        questions.add(new Question( "At the time of 1965 War the C-in-C of Pakistan Army wa", "General Muhammad Musa Khan"));
        questions.add(new Question( "The Largest cantonment of Pakistan army is located in ", "Kharian"));
        questions.add(new Question( "Who was the first Muslim C-in-C of Pakistan Army", "Field Marshal Muhammad Ayoub"));
        questions.add(new Question( "Chief of Army Staff (COAS) Gen Qamar Javed Bajwa was awarded a______________for promotion of Defence ties between Pakistan and Turkey on 20th June 2017", "Legion of Merit"));
        questions.add(new Question( "Which banned outfit’s group was destroyed by Pak Army in 3-day Mastung operation, which was carried out from June 1 to 3 – 2017", "Lashkar-i-Jhangvi Al-Almi"));
        questions.add(new Question( "Pakistan Army on launched ‘Operation Radd-ul-Fasaad’ across the country on", "22nd Feb 2017"));
        questions.add(new Question( "Till now, How many Chief of Army Staff (COAS), of Pakistan are selected from Baloch Regiment?", " Four"));
        questions.add(new Question( "Pakistan Army conducting an operation along the Pak-Afghan border in Khyber Agency, called?", "Operation Rajjgal"));
        questions.add(new Question( "Who was the first commander of islamic arm", "Hazrat Hamza (RA)"));
        questions.add(new Question( "Pakistan Army launches android Base Game on 23-March-2018", "Pakistan Army launches android Base Game on 23-March-2018"));
        questions.add(new Question( "As per Pakistan army spokesperson, Pakistan will host a dinner on it’s 78th Pakistan day, in which guests invited are", " International celebrities"));
        questions.add(new Question( "Army ___________troubled places as curfew remained in force", "patrolling"));
        questions.add(new Question( "He has _________ his mind to Join Pak Army", "made up"));
        questions.add(new Question( "Chief of Army Staff (COAS) General Qamar Javed Bajwa during his visit to Iran in Nov 2017 meet?", "All of the Above"));
        questions.add(new Question( "Navy Captain is equal in rank to arm", "Colonel"));
        questions.add(new Question( "Tipu Sultan wrote a letter to which government to help him against British Army rule in India", "France"));
        questions.add(new Question( "ARMY: LOGISTICS ::", "business: strategy"));
        questions.add(new Question( "A kind of war such is “Guerrilla” a word of Spanish its meaning is", " Little war"));
        questions.add(new Question( "In which battle did the defeat of Muslims stop their invasions ", "Battle of Tours"));
        questions.add(new Question( "What is the common factor found in the four U.S. presidents: Abraham Lincoln , James A. Garfield , William McKinley , and John F. Kennedy", "All four were assassinated "));
        questions.add(new Question( "38th Parallel line is the boundary line between", "North Korea – South Korea"));
        questions.add(new Question( "Pakistan observed ________ anniversary of APS Peshawar tragedy on 16 December 2020", "6th"));
        questions.add(new Question( "Chairman of NAB is appointed by", "President"));
        questions.add(new Question( "Which Nation sells most Advanced Warship to Pakistan", "China  "));
        questions.add(new Question( "The handing over ceremony of the Al Khalid-I tank was held at ", "Heavy Industries Taxila (HIT)"));
        questions.add(new Question( "_____________has been promoted to the Rank of Lieutenant General and Appointed as Surgeon General?", "Major Gen Nigar Johar"));
        questions.add(new Question( "The highest official rank of Pakistan Army is", "General"));
        questions.add(new Question( "The first Chief of Staff of Pak Army was", "General Takka Khan"));
        questions.add(new Question( "A batch of _______Pakistan army troops left for Central African Republic (CAR) on Sunday to perform peace-keeping duties under the aegis of the United Nations Mission", "250"));
        questions.add(new Question( "Which military exercise commenced on Monday 13 December between Pakistan and Saudi Arabia at King Khalid Military City Hafar Al Batin in Saudi Arabia", "Al-Kassah-lll"));
        questions.add(new Question( "Name the Iranian Chief of General Staff who arrives in Pakistan On October 12, 2021", "Maj Gen Mohammad Bagheri"));
        questions.add(new Question( "Who is the Current Director-General (DG) of Inter-Services Intelligence (ISI", "Lt. Gen. Nadeem Anjum"));
        questions.add(new Question( "Name the CIA director, who recently meets General Qamar Javed Bajwa, ISI chief at GHQ on 10th September 2021", " William Burns"));
        questions.add(new Question( "Who got Nishan e Haider from Gilgit Baltistan", " Hav. Lalak Jan"));
        questions.add(new Question( "Major : Battalion : : Colonel :", "Regiment"));
        questions.add(new Question( "Tragedy of Karbala was happened in _____ Hijr", "61 Hijri "));
        questions.add(new Question( "General Raheel Sharif took oath as Army Chief on", "29 November 2013"));
        questions.add(new Question( "Who was the first Commander-in-Chief of Pakistan Army", "Gen. Frank Meservy"));
        questions.add(new Question( "First Lady Major General in the Pakistan Army was", "Dr. Shahida Malik "));

        questions.add(new Question( "Constantinople, the capital of Roman Empire was captured by Turks in ", "29th May 1453"));
        questions.add(new Question( "CAA stands fo", "Civil Aviation Authority"));
        questions.add(new Question( "NAP stands for", "National Action Plan"));
        questions.add(new Question( "TA stands for", "A & B"));
        questions.add(new Question( "Chief of which Armed Force has been awarded Highest Military Award of US armed forces in March 2018 (US legion of merit)?", "Pak Air Force"));
        questions.add(new Question( "If a member of ASF deserts, who will be requested to capture the deserter", "Civil authorities"));
        questions.add(new Question( "Officers and members of ASF to be subject to the", "Pakistan Army Act, 1952"));
        questions.add(new Question( "Chief Election Commissioner Sikandar Sultan Raja was a", "Retired Civil Bureaucrat"));
        questions.add(new Question( "The Third Battle of Panipat was fought between", "Ahmad Shah Abdali and Marathas"));
        questions.add(new Question( "The Second battle of Panipat was fought between", "Hem Chandra Vikramaditya and Akbar "));

        questions.add(new Question( "Pakistan Army launched Operation Khyber-4 under Radd-ul-Fasaad (RuF) to “wipe out terrorists” in", "Rajgal valley"));
//        myRef.setValue("hello");
        myRef.setValue(questions).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void aVoid) {
                Toasty.success(getApplicationContext(), "Saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toasty.error(getApplicationContext(), "failed");
            }
        });
    }

    public void saveData2(){
        ArrayList<Question> questions = new ArrayList<>();
        myRef = database.getReference("Question1").child("Air").child("Hard");

        questions.add(new Question( "Chief of Army Staff (COAS) Gen Qamar Javed Bajwa was awarded a______________for promotion of Defence ties between Pakistan and Turkey on 20th June 2017", "Legion of Merit"));
        questions.add(new Question( "Which banned outfit’s group was destroyed by Pak Army in 3-day Mastung operation, which was carried out from June 1 to 3 – 2017", "Lashkar-i-Jhangvi Al-Almi"));
        questions.add(new Question( "Pakistan Army on launched ‘Operation Radd-ul-Fasaad’ across the country on", "22nd Feb 2017"));
        questions.add(new Question( "Till now, How many Chief of Army Staff (COAS), of Pakistan are selected from Baloch Regiment?", " Four"));
        questions.add(new Question( "Pakistan Army conducting an operation along the Pak-Afghan border in Khyber Agency, called?", "Operation Rajjgal"));
        questions.add(new Question( "Who was the first commander of islamic arm", "Hazrat Hamza (RA)"));
        questions.add(new Question( "Pakistan Army launches android Base Game on 23-March-2018", "Pakistan Army launches android Base Game on 23-March-2018"));
        questions.add(new Question( "As per Pakistan army spokesperson, Pakistan will host a dinner on it’s 78th Pakistan day, in which guests invited are", " International celebrities"));
        questions.add(new Question( "Army ___________troubled places as curfew remained in force", "patrolling"));
        questions.add(new Question( "He has _________ his mind to Join Pak Army", "made up"));
        questions.add(new Question( "Chief of Army Staff (COAS) General Qamar Javed Bajwa during his visit to Iran in Nov 2017 meet?", "All of the Above"));
        questions.add(new Question( "Navy Captain is equal in rank to arm", "Colonel"));
        questions.add(new Question( "Tipu Sultan wrote a letter to which government to help him against British Army rule in India", "France"));
        questions.add(new Question( "ARMY: LOGISTICS ::", "business: strategy"));
        questions.add(new Question( "Pakistan Army launched Operation Khyber-4 under Radd-ul-Fasaad (RuF) to “wipe out terrorists” in", "Rajgal valley"));
        questions.add(new Question( "A batch of _______Pakistan army troops left for Central African Republic (CAR) on Sunday to perform peace-keeping duties under the aegis of the United Nations Mission", "250"));
        questions.add(new Question( "Which military exercise commenced on Monday 13 December between Pakistan and Saudi Arabia at King Khalid Military City Hafar Al Batin in Saudi Arabia", "Al-Kassah-lll"));
        questions.add(new Question( "Name the Iranian Chief of General Staff who arrives in Pakistan On October 12, 2021", "Maj Gen Mohammad Bagheri"));
        questions.add(new Question( "Who is the Current Director-General (DG) of Inter-Services Intelligence (ISI", "Lt. Gen. Nadeem Anjum"));
        questions.add(new Question( "Name the CIA director, who recently meets General Qamar Javed Bajwa, ISI chief at GHQ on 10th September 2021", " William Burns"));
        questions.add(new Question( "Who got Nishan e Haider from Gilgit Baltistan", " Hav. Lalak Jan"));
        questions.add(new Question( "Major : Battalion : : Colonel :", "Regiment"));
        questions.add(new Question( "Tragedy of Karbala was happened in _____ Hijr", "61 Hijri "));
        questions.add(new Question( "General Raheel Sharif took oath as Army Chief on", "29 November 2013"));
        questions.add(new Question( "Who was the first Commander-in-Chief of Pakistan Army", "Gen. Frank Meservy"));
        questions.add(new Question( "First Lady Major General in the Pakistan Army was", "Dr. Shahida Malik "));
        questions.add(new Question( "Chief Justice Asif Saeed Khosa has taken the first-ever suo motu notice relating to the", "Reappointment of Chief of Army Staff"));
        questions.add(new Question( "Shaheen-I SSBM is capable of delivering all types of warheads up to a range of", "650km"));
        questions.add(new Question( "Recently _________diplomats visited LoC areas affected by Indian shelling", "23"));
        questions.add(new Question( "When was the Historic Quaid-i-Azam Ziarat Residency was set alight in an arson attack by militants", "June 15, 2013"));
        questions.add(new Question( "COAS General Qamar Javed Bajwa was set to retire on", "29 November 2019"));
        questions.add(new Question( "In order for power to be legitimate a government must have", "legitimate authority"));
        questions.add(new Question( "A good example of a primary group is", "a family"));
        questions.add(new Question( "In the late eighteenth century what was Jeremy Bentham,s Panopticon", "a prison"));

        questions.add(new Question( "A kind of war such is “Guerrilla” a word of Spanish its meaning is", " Little war"));
        questions.add(new Question( "In which battle did the defeat of Muslims stop their invasions ", "Battle of Tours"));
        questions.add(new Question( "What is the common factor found in the four U.S. presidents: Abraham Lincoln , James A. Garfield , William McKinley , and John F. Kennedy", "All four were assassinated "));
        questions.add(new Question( "38th Parallel line is the boundary line between", "North Korea – South Korea"));
        questions.add(new Question( "Pakistan observed ________ anniversary of APS Peshawar tragedy on 16 December 2020", "6th"));
        questions.add(new Question( "Chairman of NAB is appointed by", "President"));
        questions.add(new Question( "Which Nation sells most Advanced Warship to Pakistan", "China  "));

        questions.add(new Question( "At the time of 1965 War the C-in-C of Pakistan Army wa", "General Muhammad Musa Khan"));
        questions.add(new Question( "The Largest cantonment of Pakistan army is located in ", "Kharian"));
        questions.add(new Question( "Who was the first Muslim C-in-C of Pakistan Army", "Field Marshal Muhammad Ayoub"));
        questions.add(new Question( "Chief of Army Staff (COAS) Gen Qamar Javed Bajwa was awarded a______________for promotion of Defence ties between Pakistan and Turkey on 20th June 2017", "Legion of Merit"));
        questions.add(new Question( "Which banned outfit’s group was destroyed by Pak Army in 3-day Mastung operation, which was carried out from June 1 to 3 – 2017", "Lashkar-i-Jhangvi Al-Almi"));
        questions.add(new Question( "Pakistan Army on launched ‘Operation Radd-ul-Fasaad’ across the country on", "22nd Feb 2017"));


//        myRef.setValue("hello");
        myRef.setValue(questions).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void aVoid) {
                Toasty.success(getApplicationContext(), "Saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toasty.error(getApplicationContext(), "failed");
            }
        });
    }

    public void saveData3(){
        ArrayList<Question> questions = new ArrayList<>();
        myRef = database.getReference("Question1").child("Air").child("Medium");

        questions.add(new Question( "At the time of 1965 War the C-in-C of Pakistan Army wa", "General Muhammad Musa Khan"));
        questions.add(new Question( "The Largest cantonment of Pakistan army is located in ", "Kharian"));
        questions.add(new Question( "Who was the first Muslim C-in-C of Pakistan Army", "Field Marshal Muhammad Ayoub"));
        questions.add(new Question( "Chief of Army Staff (COAS) Gen Qamar Javed Bajwa was awarded a______________for promotion of Defence ties between Pakistan and Turkey on 20th June 2017", "Legion of Merit"));
        questions.add(new Question( "Which banned outfit’s group was destroyed by Pak Army in 3-day Mastung operation, which was carried out from June 1 to 3 – 2017", "Lashkar-i-Jhangvi Al-Almi"));
        questions.add(new Question( "Pakistan Army on launched ‘Operation Radd-ul-Fasaad’ across the country on", "22nd Feb 2017"));

        questions.add(new Question( "A kind of war such is “Guerrilla” a word of Spanish its meaning is", " Little war"));
        questions.add(new Question( "In which battle did the defeat of Muslims stop their invasions ", "Battle of Tours"));
        questions.add(new Question( "What is the common factor found in the four U.S. presidents: Abraham Lincoln , James A. Garfield , William McKinley , and John F. Kennedy", "All four were assassinated "));
        questions.add(new Question( "38th Parallel line is the boundary line between", "North Korea – South Korea"));
        questions.add(new Question( "Pakistan observed ________ anniversary of APS Peshawar tragedy on 16 December 2020", "6th"));
        questions.add(new Question( "Chairman of NAB is appointed by", "President"));
        questions.add(new Question( "Which Nation sells most Advanced Warship to Pakistan", "China  "));

        questions.add(new Question( "A batch of _______Pakistan army troops left for Central African Republic (CAR) on Sunday to perform peace-keeping duties under the aegis of the United Nations Mission", "250"));
        questions.add(new Question( "Which military exercise commenced on Monday 13 December between Pakistan and Saudi Arabia at King Khalid Military City Hafar Al Batin in Saudi Arabia", "Al-Kassah-lll"));
        questions.add(new Question( "Name the Iranian Chief of General Staff who arrives in Pakistan On October 12, 2021", "Maj Gen Mohammad Bagheri"));
        questions.add(new Question( "Who is the Current Director-General (DG) of Inter-Services Intelligence (ISI", "Lt. Gen. Nadeem Anjum"));
        questions.add(new Question( "Name the CIA director, who recently meets General Qamar Javed Bajwa, ISI chief at GHQ on 10th September 2021", " William Burns"));
        questions.add(new Question( "Who got Nishan e Haider from Gilgit Baltistan", " Hav. Lalak Jan"));
        questions.add(new Question( "Major : Battalion : : Colonel :", "Regiment"));
        questions.add(new Question( "Tragedy of Karbala was happened in _____ Hijr", "61 Hijri "));
        questions.add(new Question( "General Raheel Sharif took oath as Army Chief on", "29 November 2013"));
        questions.add(new Question( "Who was the first Commander-in-Chief of Pakistan Army", "Gen. Frank Meservy"));
        questions.add(new Question( "First Lady Major General in the Pakistan Army was", "Dr. Shahida Malik "));
        questions.add(new Question( "Chief of Army Staff (COAS) Gen Qamar Javed Bajwa was awarded a______________for promotion of Defence ties between Pakistan and Turkey on 20th June 2017", "Legion of Merit"));
        questions.add(new Question( "Which banned outfit’s group was destroyed by Pak Army in 3-day Mastung operation, which was carried out from June 1 to 3 – 2017", "Lashkar-i-Jhangvi Al-Almi"));
        questions.add(new Question( "Pakistan Army on launched ‘Operation Radd-ul-Fasaad’ across the country on", "22nd Feb 2017"));
        questions.add(new Question( "Till now, How many Chief of Army Staff (COAS), of Pakistan are selected from Baloch Regiment?", " Four"));
        questions.add(new Question( "Pakistan Army conducting an operation along the Pak-Afghan border in Khyber Agency, called?", "Operation Rajjgal"));
        questions.add(new Question( "Who was the first commander of islamic arm", "Hazrat Hamza (RA)"));
        questions.add(new Question( "Pakistan Army launches android Base Game on 23-March-2018", "Pakistan Army launches android Base Game on 23-March-2018"));
        questions.add(new Question( "As per Pakistan army spokesperson, Pakistan will host a dinner on it’s 78th Pakistan day, in which guests invited are", " International celebrities"));
        questions.add(new Question( "Army ___________troubled places as curfew remained in force", "patrolling"));
        questions.add(new Question( "He has _________ his mind to Join Pak Army", "made up"));
        questions.add(new Question( "Chief of Army Staff (COAS) General Qamar Javed Bajwa during his visit to Iran in Nov 2017 meet?", "All of the Above"));
        questions.add(new Question( "Navy Captain is equal in rank to arm", "Colonel"));
        questions.add(new Question( "Tipu Sultan wrote a letter to which government to help him against British Army rule in India", "France"));
        questions.add(new Question( "ARMY: LOGISTICS ::", "business: strategy"));
        questions.add(new Question( "Pakistan Army launched Operation Khyber-4 under Radd-ul-Fasaad (RuF) to “wipe out terrorists” in", "Rajgal valley"));
        questions.add(new Question( "Battale of ZALAQA was fought between Alfanso VI and Yousaf bin Tashfeen in", "1086"));
        questions.add(new Question( "The battle between God’s army and Satan’s rebels in heaven lasted", "Three days"));
        questions.add(new Question("Which one from the following officers of Army can disperse unlawful assembly", "Any Commissioned Officer"));
        questions.add(new Question( "An officer of Army if he is unable to sue or defend any suit due to leave he may sue or defend any suit through", "Any person authorized by him"));
        questions.add(new Question( "Who was behind the Karachi Stock Exchange attack on 29th June 2020", ""));
        questions.add(new Question( "Who was behind the Karachi Stock Exchange attack on 29th June 2020", "Balochistan Liberation Army"));
        questions.add(new Question( "The developers of which country has developed the world’s 1st digital contact tracing app utilizing the Exposure Notification API of Apple and Google", "Switzerland"));
        questions.add(new Question( "‘Quwwat ul-Islam’ Mosque is in", "Delhi"));
        questions.add(new Question( "Which Country has successful conducted a test-flight of a Hypersonic Missile after Russi", "USA"));
        questions.add(new Question( "Pakistan Maritime Security Agency Belongs Which Branch", "Pak Navy"));
        questions.add(new Question( "Port of Mobile” is the seaport of", "U.S.A"));
        questions.add(new Question( "Find the one which does not belong to that group", "Regiment"));
        questions.add(new Question( "COAS Gen Qamar Javed Bajwa inaugurated ________________ at the National Radio Telecommunication Corporation (NRTC), Haripur on January 25, 2020", "Electro\u00ADnic Warfare (EW) and Ground Surveillance Radar (GSR) testing laboratories"));
        questions.add(new Question( "The Special Forces of the Peoples’s Liberation Army of China reached Pakistan on 8 Dec 2018 to participate in the joint counterterrorism drills known as", "Warrior VI "));
        questions.add(new Question( "How many Consecutive times Pakistan Army team won gold medal in the World’s toughest Cambrian Patrol competition", "4th"));
        questions.add(new Question( "Which Country’s Army team has won the Gold Medal in the World’s toughest Cambrian Patrol Competition?", "Pakistan"));
        questions.add(new Question( "The Coldstream Guards is the oldest continuously serving regiment in the Army, belongs to which Country", "UK"));
        questions.add(new Question("Pakistan army has contributed RS ________ in the Supreme Court’s Fund for Diamer-Bhasha and Mohmand Dam", " 1 billion"));
        questions.add(new Question( "Name the Pakistan Army’s Captain, Who died in recent road accident in Khuzdar", "Qadeer khan"));

//        myRef.setValue("hello");
        myRef.setValue(questions).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void aVoid) {
                Toasty.success(getApplicationContext(), "Saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toasty.error(getApplicationContext(), "failed");
            }
        });
    }


//    public void saveData1(){
//        ArrayList<Question> questions = new ArrayList<>();
//        questions.add(new Question(1, "Who was chosen by hazrat Umar (R.A) to lead the Muslim Army in the battle of Qadsiya?", "Hazrat Ubaida bin Jerrah", "Hazrat Khalid bin Waleed(R.A)","Hazrat Saad bin Abi Waqas (R.A)","Hazrat Usama Bin Zaid (R.A)","clear"));
//        questions.add(new Question(2, "Name the Powerful Country which offered help to the Pakistan Army before surrendering in Dhaka during 1971 war?", "United kingdom", "United States","France","Russia","clear"));
//        questions.add(new Question(3, "Name the Pakistan Army cadet, who won ‘International Medal’ at Royal Military Academy Sandhurst ( RMAS) UK in April 2018?", "Bilal khan", "Sheroz Shahid","Muhammad yaseen","none of them","clear"));
//        questions.add(new Question(4, "According to Forbes Magazine in its annual ranking for 2018, Chief of Army Staff Gen Qamar Javed Bajwa has been ranked as the____________most powerful person in the world on a list of 75", "56th", "64th","68th","75th","clear"));
//        questions.add(new Question(5, "Which country has the largest army", "India", "USA","China","Russia","clear"));
//        questions.add(new Question(6, "Name the Pakistan Army’s Captain, Who died in recent road accident in Khuzdar", "Zain ali", "Javed Sultan","Qadeer khan","Ameer Faisal Alavi","clear"));
//        questions.add(new Question(7, "Which country climber was recently rescued by Pakistan Army aviation pilots on July 31st 2018, who was stuck 20,650 feet above sea level on Biafo Glacier’s Latok Peak", "French", "British","Russian","Polish","clear"));
//        questions.add(new Question(8, "Pakistan army Sepoy Maqbool Hussain who faced extreme torture in Indian prisons during his unlawful detention for ______ years died on 28th August 2018", "10", "30","40","20","clear"));
//        questions.add(new Question(9, "Until January 2019 Pakistan Army has completed how much length of fence near Afghanistan boundary", "700km", "800km","900km","1200km","clear"));
//        questions.add(new Question(10, "Maj. Gen. Alenka Ermenc is the first female Army Chief of ________ country", "Denmark", "Ukraine","Slovenia","None of These","clear"));
//        questions.add(new Question(11, "Which of the following is the only NATO country with female Army Chief?", "Turkey", "Slovenia","Poland","Luxembourg","clear"));
//        questions.add(new Question(12, "How many Consecutive times Pakistan Army team won gold medal in the World’s toughest Cambrian Patrol competition", "2nd", "3rd","4th","5th","clear"));
//
//        questions.add(new Question(13, "The Coldstream Guards is the oldest continuously serving regiment in the Army, belongs to which Country", "Japan", "Iceland","USA","UK","clear"));
//        questions.add(new Question(14, "Pakistan army Sepoy Maqbool Hussain who breathed last on 28th August 2018 got injured and was taken prisoner by the Indian Army during the _______ war?", "1971", "1999","1965","1948","clear"));
//        questions.add(new Question(15, "How many consecutive years Pakistan Army team has been the winner of Pace Sticking Competition", "Second", "Third","Fourth","None of these","clear"));
//
//        questions.add(new Question(16, "Which Country’s Army chief was shot dead during a failed coup attempt", "Germany", "Syria","Egypt","Ethiopia","clear"));
//        questions.add(new Question(17, "Pakistan Army has won an international military drill competition 2019 for second consecutive year which was held in", "USA", "UK","UAE","None of these","clear"));
//
//        questions.add(new Question(18, "The two archangels who serve as generals in God’s army are", " Michael and Gabriel", "Michael and Raphael","Raphael and Gabriel","Michael and Lucifer","clear"));
//        questions.add(new Question(19, "The battle between God’s army and Satan’s rebels in heaven lasted", "One day", "Three days","Seven days","One hour","clear"));
//        questions.add(new Question(20, "Which one from the following officers of Army can disperse unlawful assembly", "Any Commissioned Officer", "Subidar","Subidar Major","None of above","clear"));
//        questions.add(new Question(20, "An officer of Army if he is unable to sue or defend any suit due to leave he may sue or defend any suit through", "His commanding officer", "Any person authorized by him"," His elders","None of the these","clear"));
//        questions.add(new Question(21, "President Arif Alvi conferred Nishan-e-Imtiaz on Turkish Army chief General Yasar Guler on", "November 20, 2019", "November 22, 2019","November 24, 2019","None of these","clear"));
//        questions.add(new Question(22, "When Supreme Court of Pakistan suspended the notification confirming the extension of Chief of Army Staff General Qamar Javed Bajwa for another three years", "6 Nov 2019", "16 Nov 2019","20 Nov 2019","26 Nov 2019","clear"));
//        questions.add(new Question(23, "According to the 2019 Military Strengthen Ranking report released by Global Firepower, Pakistan Army ranked as the____________most Powerful Military in the World?", "15th", "16th","17th","18th","clear"));
//        questions.add(new Question(24, "Which Country’s army chief was shot dead during a failed coup attempt", "Germany", "Syria","Egypt","Ethiopia","clear"));
//        questions.add(new Question(25, "General Qamar Javed Bajwa is the_________Army Chief, Whose Tenure has been extended?", "1st", "2nd","3rd","4th","clear"));
//        questions.add(new Question(26, "When was Gen. Bajwa appointed as the Chief of Army Staff by former Prime Minister Nawaz Sharif?", "1 November 2016", "9 November 2016","19 November 2016","29 November 2016","clear"));
//        questions.add(new Question(27, "Army Chief Gen Bajwa’s term extended for another_______years on 19 August 2019 by PM of Pakistan", "1 years", "2 years","3 years","4 years","clear"));
//        questions.add(new Question(28, "A general in an army chart of command positions would constitute a", "status", "role","norm","institution","clear"));
//        questions.add(new Question(29, "National assembly passes army amendment act (1952) on", "January 6, 2020", "January 7, 2020","January 8, 2020","January 9, 2020","clear"));
//        questions.add(new Question(30, "Which Country’s powerful army chief, General Ahmed Gaid Salah, died in December 2019", "South Africa", "Somalia","Algeria","Nigeria","clear"));
//        questions.add(new Question(31, "On 13 February 1739, Nadir Shah crushed the Mughal army in less than three hours at the huge", "Battle of Karnal", "Battle of Chausa","Battle of Tarain"," Battle of Plassey","clear"));
//        questions.add(new Question(32, "US Resumes Military Training Program for Pakistan Army, Offers _______Billion in Aid", "$2 Billion", "$3 Billion","$4 Billion","None of these","clear"));
//        questions.add(new Question(33, "The Colour of the Flag of the Islamic Army in Ghazwa Badr was", "GREEN", "YELLOW","PINK","NONE","clear"));
//        questions.add(new Question(34, "Which Regiment of Pakistan Army has awarded maximum number of Nishan-e-Haider", "Balochistan Regiment", "Punjab Regiment","Sindh Regiment","Pakhtunkhuwah Regiment","clear"));
//        questions.add(new Question(35, "President of Pakistan is empowered to appoint Chief of the Army Staff under which article of Constitution of Pakistan 1973", "243(3)(a)", "243(4)(b)","243(3)(c)","None of these","clear"));
//        questions.add(new Question(36, "How long extension has been given by SCP to Gen Qamar Javed Bajwa to remain the Chief of Army Staff (COAS) on 28 Nov, 2019?", "3 month", "6 month","9 month","12 month","clear"));
//        questions.add(new Question(37, "Which country’s army chief names new governing sovereign council", "Sudan", "Myanmar","Indonesia","China","clear"));
//        questions.add(new Question(38, "Recently, New Air Defense System commissioned into Pak Army, Named", "Iron Dome", "RIM-161"," S-300V","HQ-9/P HIMADS","clear"));
//        questions.add(new Question(39, "The retired officers of Indian Army are recruited by real estate firms is an example of", "phased retirement", "flexible work","honoring experience","modifying selection procedure","clear"));
//        questions.add(new Question(40, "Lt Gen Azhar Abbas is the __________ Chief of General Staff (CGS) of Pakistan Army", "30th", "35th","40th","None of these","clear"));
////        questions.add(new Question(41, "", "", "","","",""));
////        questions.add(new Question(42, "", "", "","","",""));
////        questions.add(new Question(43, "", "", "","","",""));
////        questions.add(new Question(44, "", "", "","","",""));
////        questions.add(new Question(45, "", "", "","","",""));
////        questions.add(new Question(46, "", "", "","","",""));
////        questions.add(new Question(47, "", "", "","","",""));
////        questions.add(new Question(48, "", "", "","","",""));
////        questions.add(new Question(49, "", "", "","","",""));
////        questions.add(new Question(50, "", "", "","","",""));
//
////        myRef.setValue("hello");
//        myRef.setValue(questions).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(@NonNull Void aVoid) {
//                Toasty.success(getApplicationContext(), "Saved");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toasty.error(getApplicationContext(), "failed");
//            }
//        });
//    }

}