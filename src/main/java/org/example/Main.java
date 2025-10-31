package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }


    Các bước CI/CD trên GitHub

    B1: khởi tạo git
    git init
    git add .
    git commit -m "Initial commit of project"
    git branch -M main
    git remote add origin <<link github>>
    git push -u origin main

    B2: Tạo CI
    mkdir -p .github/workflows

    B3: tao notepad
    notepad .github/workflows/ci.yml

    B4 : them cyml
    name: Java CI

    on:
      push:
        branches: [ "main" ]
      pull_request:
        branches: [ "main" ]
      workflow_dispatch:

    jobs:
      build:
        runs-on: ubuntu-latest

        steps:
          - uses: actions/checkout@v4
          - name: Set up JDK 17
            uses: actions/setup-java@v4
            with:
              java-version: '17'
              distribution: 'temurin'
          - name: Build with Maven
            run: mvn -B package --file pom.xml
     B5 : commit
    git add .
    git commit -m"feat: Add Github Actions CI workflow for Java"
    git push origin main



}