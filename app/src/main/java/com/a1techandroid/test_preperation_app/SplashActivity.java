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

    public void saveData(){
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(1, "First-ever Female as Colonel Commandant of Army Medical College is","18","6","3","0", "clear answer"));
        questions.add(new Question(2, "Camera is to photographer as _____ Is to the soldier","Lens","Enemy","Photo","Gun", "clear answer"));
        questions.add(new Question(3, "Complete the series","6","5","12","10", "clear answer"));
        questions.add(new Question(4, "Which choice answers the following question? Islamabad is famous because:","It is a very clear city","Numerous foreigners live in it","The President lives in it","It is the capital of Pakistan", "clear answer"));
        questions.add(new Question(5, "Which country of the South America is known as ‘Granary of Europe’","Chile","Argentina","Brazil","Peru", "clear answer"));
        questions.add(new Question(6, "Which Asian country is home to the most nuclear power plants","China","South Korea","Taiwan","None of these", "clear answer"));
        questions.add(new Question(7, "How many U.S. states border the Pacific Ocean","Four","Three","Five","Seven", "clear answer"));
        questions.add(new Question(8, "Mojave Desert desert is located in","Afghanistan","India","Australia","USA", "clear answer"));
        questions.add(new Question(9, "The creator of the popular numbers puzzle Sudoku","Maki Kaji","Shinzo Teng","Mami Suzuki","Hiroko Akutsu", "clear answer"));
        questions.add(new Question(10, "What is the new name of the island of Madagascar","Haitti","Malagasy","Mozambique","Maputo", "clear answer"));
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

    public void saveData1(){
        ArrayList<Question> questions = new ArrayList<>();
        myRef = database.getReference("Question1").child("Air").child("Easy");

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