package com.mycom.word;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    //Scanner s = new Scanner(System.in);
    Scanner s;
    final String fname = "data.txt";

    WordCRUD(Scanner s) {
        list = new ArrayList<>();
        this.s = s;
    }
    public void listAll() {
        System.out.println("---------------------------------");
        for(int i = 0; i < list.size(); i++) {
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("---------------------------------");
    }

    public void listAll(int level) {
        int j = 0;
        System.out.println("---------------------------------");
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getLevel() == level) {
                System.out.print((j + 1) + " ");
                System.out.println(list.get(i).toString());
                j++;
            }
        }
        System.out.println("---------------------------------");
    }

    public ArrayList<Integer> listAll(String keyword) {
        ArrayList<Integer> idList = new ArrayList<>();
        int j = 0;

        System.out.println("---------------------------------");
        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i).getWord();
            if(word.contains(keyword)) {
                System.out.print((j + 1) + " ");
                System.out.println(list.get(i).toString());
                idList.add(i);
                j++;
            }
        }
        System.out.println("---------------------------------");

        return idList;
    }

    public void searchLevel() {
        System.out.print("=> 레벨(1: 초급, 2: 중급, 3: 고급) 선택 : ");
        int level = s.nextInt();
        this.listAll(level);
    }

    public void searchItem() {
        System.out.print("=> 검색할 단어 입력 : ");
        String keyword = s.next();
        listAll(keyword);
        //ArrayList<Integer> idList = this.listAll(keyword);
    }
    @Override
    public Object add() {
        System.out.println("---------------------------------");
        System.out.print("난이도(1, 2, 3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level,  word, meaning);
    }

    public void addWord() {
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 추가되었습니다. ");
        System.out.println("---------------------------------");
    }

    public void updateItem() {
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next();

        ArrayList<Integer> idList = this.listAll(keyword);
        if(!idList.isEmpty()) {
            System.out.print("=> 수정할 번호 선택 : ");
            int id = s.nextInt();
            s.nextLine(); // 버퍼 비우기
            System.out.print("=> 뜻 입력 : ");
            String meaning = s.nextLine();
            Word word = list.get(idList.get(id - 1));
            word.setMeaning(meaning);

            System.out.println("단어가 수정되었습니다.");
        }
    }

    public void deleteItem() {
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword = s.next();

        ArrayList<Integer> idList = this.listAll(keyword);
        if(!idList.isEmpty()) {
            System.out.print("=> 삭제할 번호 선택 : ");
            int id = s.nextInt();
            s.nextLine(); // 버퍼 비우기
            System.out.print("=> 정말로 삭제하실래요?(Y/n) : ");
            String ans = s.next();
            System.out.println(ans);

            if (ans.equalsIgnoreCase("y")) {
                list.remove((int)idList.get(id - 1));
                System.out.println("단어가 삭제되었습니다.");
            }
            else System.out.println("취소되었습니다.");
        }
    }

    public void loadFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;

            while (true) {
                line = br.readLine();
                if (line == null) break;
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0, level, word, meaning));
                count++;
            }
            br.close(); // ??
            System.out.println("==> " + count + "개 데이터 로딩 완료!");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for (Word one : list) {
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("==> 데이터 저장 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
}
