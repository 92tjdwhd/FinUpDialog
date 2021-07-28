# FinUpDialog

[![](https://jitpack.io/v/92tjdwhd/FinUpDialog.svg)](https://jitpack.io/#92tjdwhd/FinUpDialog)

# PreView

![Style1](https://user-images.githubusercontent.com/22476309/127270069-1194248b-1857-4d60-862e-d065925c4544.PNG)
![Style2](https://user-images.githubusercontent.com/22476309/127270079-e8e5fcc4-1244-4411-a352-90018202ad13.PNG)

# Describe

핀업 안드로이드 전용 다이얼로그 라이브러리입니다. \
핀업 디자인 스타일에 맞춰 다이얼로그를 제작 제공합니다.
간단한 사용방법으로 구현 가능합니다.\
지속적으로 더 다양한 사용자 정의 속성을 제공 업데이트합니다.

# Usage

Step1 

    allprojects {
	  	repositories {
		  	...
		  	maven { url 'https://jitpack.io' }
		  }
	  }
    

Step2

    dependencies {
	           implementation 'com.github.92tjdwhd:FinUpDialog:Tag'
	  }
    
다이얼로그 생성

    FinUpDialogBuilder()
                .setTitle("Title")
                .setContentText("Content")
                .positiveButton("확인") {
                   
                }
                .negativeButton("취소") {

                }
                .build()
                .show(supportFragmentManager,"normal")
                
                
 # Attributes
 
 1. <code>setTitle </code> <br> - 타이틀
 2. <code>setContentText </code> <br> - 내용
 3. <code>setContentTextStringBuilder </code> <br> - SpannableString 내용 적용
 4. <code>setContentISBold </code> <br> - 내용 폰트타입 Bold
 5. <code>setTitleISBold </code> <br> - 타이틀 폰트타입 Bolde
 6. <code>setTextSize </code> <br> - 폰트 사이즈
 7. <code>positiveButton </code> <br> - 기본 확인 버튼
 8. <code>negativeButton </code> <br> - 부정 버튼 추가시 하단 버튼 2개 생성 미입력시 버튼 1개 생성
 9. <code>setPointColor </code> <br> - 포인트 컬러 색상
 10. <code>enableCancel </code> <br> - 화 상자 외부를 터치하여 대화 상자를 닫고 싶지 않다면 false로 설정하십시오.
  
  
 # License
 Copyright (c) 2021 

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
 


