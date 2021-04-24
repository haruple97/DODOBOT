# DODOBOT
Daegu University AI Chatbot Application

대구대학교 인공지능 챗봇 애플리케이션
챗봇 기능 외에 학사일정 교내 건물 위치 등 학교관련 정보를 습득할 수 있는 프로그램.
<br/>

## 메인화면

<img src = "https://user-images.githubusercontent.com/73948775/115711887-0f865c00-a3af-11eb-9046-e0a90746a4b3.gif" width="250px">

메인화면이다. 인트로 이후 나오는 메인페이지에는 학생들의
학교관련 카드뉴스 및 학사일정을 배치하였다.
학교 정보 관련 아이콘을 직관적으로 확인할 수 있다.

<br/>



## AI 챗봇
<img src = "https://user-images.githubusercontent.com/73948775/115713788-5bd29b80-a3b1-11eb-90d6-25abef1e8913.gif" width="250px">


- 사용 API : Watson Assistant
- 챗봇의 캐릭터 명 : 두두봇

Watson Assistant API를 사용하여 개발하였으며, 사용자가 질문시 두두봇이 답변해주는 챗봇 화면이다.
학교, 학사일정, 건물 위치 등을 왓슨에 등록하였으며 왓슨이 등록한 언어에 가깝다고 생각하면,
등록한 답변을 출력한다..

<br/>

## 교내지도
<img src = "https://user-images.githubusercontent.com/73948775/115957548-155e7780-a53e-11eb-9f3c-fd6152ac6bfd.gif" width="250px">


네이버 클라우드 플랫폼의 '네이버지도 API' 이용하여 개발.
Spinner를 사용하여 찾는 건물을 선택할 수 있다.
건물 선택시 해당 건물의 정보 및 건물로 줌인효과 적용.





