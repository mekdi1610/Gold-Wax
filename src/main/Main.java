package main;

import edu.cmu.lti.jawjaw.pobj.POS;
import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.lexical_db.data.Concept;
import edu.cmu.lti.ws4j.Relatedness;
import edu.cmu.lti.ws4j.RelatednessCalculator;
import edu.cmu.lti.ws4j.impl.WuPalmer;
import edu.cmu.lti.ws4j.util.WS4JConfiguration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;

/**
 *
 * @author mekdi
 */
public class Main extends javax.swing.JFrame {
    Hashtable<Integer, String> Hibreqal = new Hashtable<Integer, String>();
    static String Sem= "";
    static String Werk= "";
    static String HibreKal = "";
    List<String> Candidatelists= new ArrayList<String>();
    private static ILexicalDatabase db = new NictWordNet();
    String candidatesOfwords="";
    static List<String> arrlists= new ArrayList<String>();
    static List<String> affixRemoved= new ArrayList<String>();
    static List<String> meaningOfAllNouns= new ArrayList<String>();
    static List<String> meaningOfAllVerbs= new ArrayList<String>();
    static List<String> meaningOfAffixes= new ArrayList<String>();
    static List<String> hiberKalMeaning= new ArrayList<String>();
    public Main() {
        initComponents();
        jTextArea1.setText("እጅግ ሥራ አዋቂ ትናንት ተቀበረች\n" +
                            "መድኃኒቱን ምሳ ታበላኝ ነበረ");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Power Geez Unicode1", 3, 18)); // NOI18N
        jLabel1.setText("               የአማርኛ ሰምና ወርቅ ቅኔ መፍቻ");

        jLabel2.setFont(new java.awt.Font("Power Geez Unicode1", 0, 14)); // NOI18N
        jLabel2.setText(" ቅኔዎችን ያስገቡ");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Power Geez Unicode1", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Power Geez Unicode1", 0, 14)); // NOI18N
        jButton1.setText("ውጤት አሳይ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                  jTextArea2.setText("Processing ...");
                   jTextArea2.update(jTextArea2.getGraphics());
                    jButton1ActionPerformed(evt);  
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Power Geez Unicode1", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel3.setFont(new java.awt.Font("Power Geez Unicode1", 0, 18)); // NOI18N
        jLabel3.setText(" Amharic Wax and Gold Extraction Helper Application");

        jLabel4.setFont(new java.awt.Font("Power Geez Unicode1", 0, 14)); // NOI18N
        jLabel4.setText("የተገኙ ቃላት");

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Power Geez Unicode1", 0, 12)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Action triggeded when button is clicked
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            Sem = ""; Werk = ""; candidatesOfwords = ""; HibreKal="";
            String readText=jTextArea1.getText();
            readText=readText.replaceAll("[\r\n]+", " "); //Split to read
            getHibreKal(readText);
            getMeaningOfAll(readText);
            jTextArea2.setText("");
            jTextArea2.append(HibreKal);
            jTextArea2.update(jTextArea2.getGraphics());
            calculateRelatedness();
            jTextArea2.append("=================================\n");   
            jTextArea2.append("\n"+Sem+"\n"+Werk+"\n");
            jTextArea2.append("=================================\n");
            if(hiberKalMeaning.size()==0){
                jTextArea2.setText("ህብረ ቃል አልተገኘም");
            }
      
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //Connection to the database
    public static ResultSet sqlConnection(String query) {
        String sDriverName = "org.sqlite.JDBC";
        try {
            Class.forName(sDriverName);
            } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
           }
        String sTempDb = "/home/mekdi/NLP Project/Database/nlp.sqlite";
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;
        String sMakeSelect = query;
        // create a database connection
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(sDbUrl);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                ResultSet rs = stmt.executeQuery(sMakeSelect);
                return rs;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
      }
    }
    
         //Get the hibrekal from the user qene
     public  void getHibreKal(String statement){
        hiberKalMeaning.clear();
        String [] listOfWords = statement.split(" ");
        String success = null;
        for (int i = listOfWords.length-1;i>0;i--){
            success= getDoubleMeaning(listOfWords[i]);
            if(success!=null){
                break;
            }
        }
        if(success!=null){
            System.out.println("Successful!");
        }
        else{
            Joining(statement);
        }
    }
    // Get the variation of the hibrekal
    public String getDoubleMeaning (String candidate) {
        candidatesOfwords +=candidate+"\n";
        jTextArea3.setText(candidatesOfwords);
        jTextArea3.update(jTextArea3.getGraphics());
        String query = "SELECT * from homonyms where first = '" + candidate + "'";
        String hiberekalNoun=null;
        String hiberekalVerb=null;
        ResultSet rs = sqlConnection(query);
        try {
            while (rs.next()) {
                System.out.println(" HibreKal:  " + candidate);
                hiberekalNoun = rs.getString("second");
                String nounMeaning = getNouns(hiberekalNoun);
                System.out.println(hiberekalNoun + " => " + nounMeaning);
                
                hiberekalVerb = rs.getString("third");
                String verbMeaning = getVerbs(hiberekalVerb);
                //Both variation may be verbs so check in the verbs table
                if(nounMeaning==""){
                    nounMeaning = getVerbs(hiberekalNoun);
                    hiberKalMeaning.add(nounMeaning.replaceAll(",", ""));
                }
                else{
                    hiberKalMeaning.add(nounMeaning.replaceAll(",", ""));
                }
                //Both variation may be nouns so check in the nouns table
                if(verbMeaning==""){
                    verbMeaning = getNouns(hiberekalVerb);
                    hiberKalMeaning.add(verbMeaning.replaceAll(",", ""));
                }
                else{
                    hiberKalMeaning.add(verbMeaning.replaceAll(",", ""));
                }
                System.out.println(hiberekalVerb + " => " + verbMeaning.replace(",", ""));
                arrlists.add(hiberekalNoun);
                arrlists.add(hiberKalMeaning.get(0));
                arrlists.add(hiberekalVerb);
                arrlists.add(hiberKalMeaning.get(0));
                HibreKal = "ህብረ ቃል: "+candidate + "\n" + "ትርጉም: "+ "\n" +  hiberekalNoun + " => "+hiberKalMeaning.get(0) + "\n" +  hiberekalVerb + " => " + hiberKalMeaning.get(1)+"\n";
            }
            if(hiberekalVerb==null){
                String s = getDoubleMeaningFromVerbs(candidate);
            }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hiberekalVerb;
    }
    
    //Get english verb meaning from the database
    public static String getVerbs (String verbMeaning){
        if (verbMeaning.isEmpty() != true) {
            String getVerb = "SELECT * from verbs where amharic = '" + verbMeaning + "'";
            ResultSet rsVerb = sqlConnection(getVerb);
            String english = "";
            try {
                if (rsVerb.next() == true) {
                    do {
                        english = rsVerb.getString("english");
                        return english;
                    } while (rsVerb.next());
                } else if (rsVerb.next() == false) { //If the verb is not found
                    String prefixRemovedWord = removePrefix(verbMeaning);
                    String suffixRemoved = removeSuffix(prefixRemovedWord);
                    if(suffixRemoved!=verbMeaning) {
                        String s = getVerbs(suffixRemoved);
                        return s;
                    }
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return english;
        }    else {
               System.out.println("Empty Set");
        }
        return "";
    }
    //Get nouns meaning from database
    public static String getNouns (String nounMeaning){
        if (nounMeaning.isEmpty() != true) {
            String getNoun = "SELECT * from nouns where amharic = '" + nounMeaning + "'";
            ResultSet rsNoun = sqlConnection(getNoun);
            String english = "";
            try {
                if (rsNoun.next() == true) {
                    do {
                        english = rsNoun.getString("english");
                        return english;
                    } while (rsNoun.next());
                }
                else if (rsNoun.next() == false) { //If noun is not found
                    String prefixRemovedWord = removePrefix(nounMeaning);
                    String suffixRemoved = removeSuffix(prefixRemovedWord);
                    if(suffixRemoved!=nounMeaning) {
                        String s = getNouns(suffixRemoved);
                        return s;
                    }
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return english;
            }else {
                System.out.println("Empty Set");
            }
        return "";
    }
    
    //Remove common prefixes
    public static  String removePrefix(String word) {
        String[] prefixes = {"ስለ", "ወደ", "ከ", "በ", "ለ", "የ", "እንደ", "እስከ", "ማ"};
        String wordSplitted = word;
        if(wordSplitted.startsWith("ያ")){
            String[] annomaly = wordSplitted.split("ያ");
            wordSplitted = "አ"+annomaly[1];
            return wordSplitted;
        }
        for (int i = 0; i < prefixes.length; i++) {
            if (wordSplitted.startsWith(prefixes[i]) == true) {
                String[] split = word.split(prefixes[i]);
                wordSplitted = split[1];
            }
        }
        return wordSplitted;
    }
    
    //Remove common suffixes
    public static  String removeSuffix(String word){
        String[] suffixes = {"ን", "ም", "ስ", "ሳ", "ማ", "ና", "ህ"};
        String wordSplited = word;
        for (int i = 0;i < suffixes.length;i++) {
            if (wordSplited.endsWith(suffixes[i]) == true) {
                String[] split = wordSplited.split(suffixes[i]);
                if(split.length!=0){
                wordSplited = split[0];
                if(wordSplited.endsWith("ቱ")){
                    String [] split2 =wordSplited.split("ቱ");
                    wordSplited = split2[0]+"ት";
                    }
                }
            }
        }
        return wordSplited;
    }
    


    //Get verbs english translations when both variation of the homonymns are verbs
    public  String getDoubleMeaningFromVerbs(String word){
        if (word.isEmpty() != true) {
            String getCount = "Select count(word) as numb from nlp where word ='" + word + "' ";
            ResultSet rs = sqlConnection(getCount);
            String count = "";
            try {
                do {
                    count = rs.getString("numb");
                    if (count.compareTo("2")==0) {
                        String getGeneralTerm = "Select englishTerm from nlp where word ='" + word + "' ";
                        ResultSet rs2 = sqlConnection(getGeneralTerm);
                        String english = "";
                        try {
                            do {
                                english = rs2.getString("englishTerm");
                                hiberKalMeaning.add(english.replaceAll(",", ""));

                            } while (rs2.next());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } while (rs.next());
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            return "";
        }

        return "";
    }
    
    //Split and join letters to form words to check for double meanings
    public void Joining( String statement) {
        //Check first
        statement = statement.replaceAll(" ", "");
        String[] data = statement.split("");
        String s = ""; int flag=0;
        int k = data.length;
         for (int i = k-1; i > 0; i--) {
            int j = i - 2;
            String st;
            if (j < data.length && j!=0 && (i-1)>0) {
                st = data[i-1] + data[i];// take two words
                String success = getDoubleMeaning(st);
                if(success==null){
                    continue;
                }
                else{
                    flag =1;
                    break;
                }
            }
         }
         if(flag==0)
         for (int i = k-1; i > 0; i--) {
             int l = i - 3;
             String st;
            if (l < data.length && l!=0 && (i-2)>0) {
                st = data[i-2] + data[i - 1] + data[i]; // take 3 word
                String success = getDoubleMeaning(st);
                if(success==null){
                    continue;
                }
                else{
                    flag =1;
                    break;
                }
            }
         }
         if(flag==0)
         for (int i = k-1; i > 0; i--) {
               int m = i - 4;
               String st;
            if (m < data.length && m!=0 && (i-3)>0) {
                st = data[i-3] + data[i -2] + data[i -1] + data[i]; // take 4 words
                String success = getDoubleMeaning(st);
                if(success==null){
                    continue;
                }
                else{
                    flag =1;
                    break;
                }
            }

        }
           if(flag==0)
           for (int i = k-1; i > 0; i--) {
            String st;
            int n = i - 5;
             if (n < data.length && n!=0 && (i-4)>0) {
                st = data[i-4] + data[i-3] + data[i -2] + data[i -1] + data[i]; // take 5 words
                String success = getDoubleMeaning(st);
                if(success==null){
                    continue;
                }
                else{
                    flag =1;
                    break;
                }
            }
        }
    }

    //Get the meaning of the rest of the qene
    public static void getMeaningOfAll( String statement){
        String noun, verbVariation;
        String [] listOfWords = statement.split(" ");
        if(hiberKalMeaning.size()!=0)
        for (int i = 0;i<listOfWords.length;i++){
            noun = getNouns((listOfWords[i])).replaceAll("[^a-zA-Z0-9]","");;
            verbVariation = getGeneralForm((listOfWords[i])).replaceAll("[^a-zA-Z0-9]","");
            String hibrekalNoun = hiberKalMeaning.get(0).replaceAll("[^a-zA-Z0-9]","");
            String hibrekalVerb = hiberKalMeaning.get(1).replaceAll("[^a-zA-Z0-9]","");
            if(noun.contains(hibrekalNoun)==false && noun.contains(hibrekalVerb)==false){
                affixRemoved.add(getNouns((listOfWords[i])));
            }
            if(verbVariation.contains(hibrekalVerb)==false && verbVariation.contains(hibrekalNoun)==false){
                affixRemoved.add(getGeneralForm((listOfWords[i])));
            }
        }
    }

    //Get meaning from the general forms
    public static  String getGeneralForm (String word) {
        if (word.isEmpty() != true) {
            String generalFormat = "Select englishTerm from nlp where word ='" + word + "' ";
            ResultSet rs = sqlConnection(generalFormat);
            String english = "";
            try {
                if (rs.next() == true) {
                    do {
                        english = rs.getString("englishTerm");
                        return english;

                    } while (rs.next());
                } else {
                    return "";
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return "";
        }
    }
      //To tag the hibrekal with its part of speech
      public static String getPartOfSpeech(String pharse){
      InputStream inputStream = null;
        try {
            //Loading Parts of speech-maxent model
            inputStream = new 
                 FileInputStream("/home/mekdi/NLP Project/Libraries/en-pos-maxent.bin");
            POSModel model = new POSModel(inputStream);
            //Instantiating POSTaggerME class
            POSTaggerME tagger = new POSTaggerME(model);
            String sentence = pharse;
            //Tokenizing the sentence using WhitespaceTokenizer class
            WhitespaceTokenizer whitespaceTokenizer= WhitespaceTokenizer.INSTANCE;
            String[] tokens = whitespaceTokenizer.tokenize(sentence);
            //Generating tags
            String[] tags = tagger.tag(tokens);
            //Instantiating the POSSample class
            POSSample sample = new POSSample(tokens, tags);
            return sample.toString();
            } catch (FileNotFoundException ex) {
               System.out.println("Exception: "+ex);
            } catch (IOException ex) {
               System.out.println("Exception: "+ex);
            } finally { 
                try {
                    inputStream.close();
                } catch (IOException ex) {
                 System.out.println("Exception: "+ex);
                }
            }
        return "";
        
    }
    
      //Calculated word relatedness amoung the hibrekals and the rest of the qene
    public static void calculateRelatedness() {
        if(hiberKalMeaning.size()!=0){
        String affix = "";
        for(int i = 0; i<affixRemoved.size();i++){
            affix=affixRemoved.get(i).replaceAll("[^a-zA-Z0-9]"," ");
            meaningOfAffixes.add(affix);
        }
        HashSet<String> uniqueMeanings = new HashSet<String>(meaningOfAffixes);
        String[] uniMeanings = uniqueMeanings.toArray(new String[uniqueMeanings.size()]);
        String[] uniHibreKalMeanings;
        if(hiberKalMeaning.size()>2){
             HashSet<String> uniqueHibreKalMeanings = new HashSet<String>(hiberKalMeaning);
               uniHibreKalMeanings = uniqueHibreKalMeanings.toArray(new String[uniqueHibreKalMeanings.size()]);
        }
        else{
            uniHibreKalMeanings = hiberKalMeaning.toArray(new String[hiberKalMeaning.size()]);
        }
        
        if(uniHibreKalMeanings.length>1){
         String [] hibrekalOne=uniHibreKalMeanings[0].replaceAll("[^a-zA-Z0-9'']"," ").replaceAll("\\s+", " ").split(" ");
        
        String [] hibrekalTwo= uniHibreKalMeanings[1].replaceAll("[^a-zA-Z0-9]"," ").replaceAll("\\s+", " ").split(" ");
        
        int length= 0;
        if(hibrekalOne.length!=0 && hibrekalOne.length<hibrekalTwo.length){
            length = hibrekalOne.length;
        }
        else if(hibrekalOne.length!=0 ){
            length = hibrekalTwo.length;
        }
            //set POS
            String partOfSpeechOne = getPartOfSpeech(hibrekalOne[0]);
            POS posCharOne = POS.n;
            String [] partOfSpeechOneChar = partOfSpeechOne.split("_");
            if(partOfSpeechOneChar[1].contains("N")){
                posCharOne = POS.n;
            }
            else if(partOfSpeechOneChar[1].contains("V")){
                 posCharOne = POS.v;
            }
            else if(partOfSpeechOneChar[1].contains("J")){
                 posCharOne = POS.a;
            }
            else{
             posCharOne = POS.v;   
            }
        double sumOne = 0;
        double sumTwo = 0;
        for(int i=0; i<uniMeanings.length; i++){
            for(int j=0; j<length; j++){
                if(hibrekalOne[j]!=" " && uniMeanings[i]!=""){
                    String [] eachWordInMeaning = uniMeanings[i].split(" ");
                    for(int k =0; k<eachWordInMeaning.length;k++) {
                        if(eachWordInMeaning[k].length()!=0 && hibrekalOne[j].length()!=0){
                            double distance1 = wordSimilarity(eachWordInMeaning[k],POS.n, hibrekalOne[j],posCharOne);
                            double distance2 = wordSimilarity(eachWordInMeaning[k],POS.v, hibrekalOne[j],posCharOne);
                            double distance3 = wordSimilarity(eachWordInMeaning[k],POS.a, hibrekalOne[j],posCharOne);
                            double distance4= wordSimilarity(eachWordInMeaning[k],POS.r, hibrekalOne[j],posCharOne);
                            if(distance1>distance2 && distance1>distance3 && distance1>distance4){
                                sumOne=sumOne+distance1;
                            }
                            else if(distance2>distance1 && distance2>distance3 && distance2>distance4) {
                                sumOne = sumOne + distance2;
                            } else if (distance3>distance1 && distance3>distance2 && distance3>distance4) {
                                sumOne = sumOne + distance3;
                            }
                            else{
                                sumOne = sumOne + distance4;
                            }
                        }
                    }
                }
            }
           for(int j=0; j<length; j++){
                if(hibrekalTwo[j]!=" " && uniMeanings[i]!=""){
                    String [] eachWordInMeaning = uniMeanings[i].split(" ");
                    for(int k =0; k<eachWordInMeaning.length;k++) {
                        if(eachWordInMeaning[k].length()!=0 && hibrekalTwo[j].length()!=0){
                            double distance1 = wordSimilarity(eachWordInMeaning[k],POS.n, hibrekalTwo[j],POS.v);
                            double distance2 = wordSimilarity(eachWordInMeaning[k],POS.v, hibrekalTwo[j],POS.v);
                            double distance3 = wordSimilarity(eachWordInMeaning[k],POS.a, hibrekalTwo[j],POS.v);
                            double distance4= wordSimilarity(eachWordInMeaning[k],POS.r, hibrekalTwo[j],POS.v);

                            if(distance1>distance2 && distance1>distance3 && distance1>distance4){
                                sumTwo=sumTwo+distance1;
                            }
                            else if(distance2>distance1 && distance2>distance3 && distance2>distance4) {
                                sumTwo = sumTwo + distance2;
                            } else if (distance3>distance1 && distance3>distance2 && distance3>distance4) {
                                sumTwo = sumTwo + distance3;
                            }
                            else{
                                sumTwo = sumTwo + distance4;
                            }
                        }

                    }
                }
            }
        }
        System.out.println("Weight1: "+sumOne);
        System.out.println("Weight2: "+sumTwo);
        double aveOne = sumOne/uniMeanings.length;
        double aveTwo = sumTwo/uniMeanings.length;
        if(aveOne> aveTwo){
             Sem ="=> ሰም: " + arrlists.get(0)+ " ("+uniHibreKalMeanings[0]+")";
             Werk ="=> ወርቅ: "+arrlists.get(2)+ " ("+ uniHibreKalMeanings[1]+")";
             System.out.println(Sem ="=> ሰም: " + arrlists.get(0)+ " ("+uniHibreKalMeanings[0]+")");
             System.out.println(Werk ="=> ወርቅ: "+arrlists.get(2)+ " ("+ uniHibreKalMeanings[1]+")");
         
        }
        else{
            Sem ="=> ሰም: "+ arrlists.get(2)+   " ("+uniHibreKalMeanings[1]+")";
            Werk ="=> ወርቅ: "+arrlists.get(0)+ " ("+uniHibreKalMeanings[0]+")";
             System.out.println(Sem ="=> ሰም: " + arrlists.get(2)+ " ("+uniHibreKalMeanings[1]+")");
             System.out.println(Werk ="=> ወርቅ: "+arrlists.get(0)+ " ("+ uniHibreKalMeanings[0]+")");
        }
        }
        }
        arrlists.clear();

    }
    //Calculate word similarity
    static RelatednessCalculator rc = new WuPalmer(db);
    public static double wordSimilarity(String word1, POS posWord1, String word2, POS posWord2) {
        double maxScore = 0;
        try {
            WS4JConfiguration.getInstance().setMFS(true);
            List<Concept> synsets1 = (List<Concept>) db.getAllConcepts(word1, posWord1.name());
            List<Concept> synsets2 = (List<Concept>) db.getAllConcepts(word2, posWord2.name());
            for (Concept synset1 : synsets1) {
                for (Concept synset2 : synsets2) {
                    Relatedness relatedness = rc.calcRelatednessOfSynset(synset1, synset2);
                    double score = relatedness.getScore();
                    if (score > maxScore) {
                        maxScore = score;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Expection: "+e);
        }
        return maxScore;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration
}