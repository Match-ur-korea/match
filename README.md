# match

# match 소개
이용자 맞춤 관광지를 추천하고 미디어 매체를 통해 디지털 여행 경험을 제공하는 웹 사이트입니다.
한국관광공사 데이터를 기반으로 관광지가 추천됩니다.

### 메인 화면 
<img width="600" alt="KakaoTalk_Photo_2021-11-07-15-12-06 004" src="https://user-images.githubusercontent.com/80243543/140634557-1016d2ed-1845-46da-abcc-14c2e0ebf918.png">

### 여행 테스트 페이지 
<img width="600" alt="KakaoTalk_Photo_2021-11-07-15-12-06 003" src="https://user-images.githubusercontent.com/80243543/140634587-0b22e3de-d181-44ff-a249-927a8f15ae1d.png">
<img width="600" alt="KakaoTalk_Photo_2021-11-07-15-12-06 002" src="https://user-images.githubusercontent.com/80243543/140634594-a660040a-f832-457c-b052-4330e529ebe0.png">
<img width="600" alt="KakaoTalk_Photo_2021-11-07-15-12-05 001" src="https://user-images.githubusercontent.com/80243543/140634598-87137c9d-df98-4a7a-9ca8-29e2d5f5bfa0.png">

### 여행 테스트 결과 페이지 
각자의 테스트 결과에 맞는 캐릭터가 표시되고 안 맞는 캐릭터 / 잘 맞는 캐릭터가 표시된다. 아래에는 결과를 바탕으로 한국관광공사 데이터에 따른 맞춤형 관광지가 지도의 마커에 표시됩니다.

<img width="600" alt="KakaoTalk_Photo_2021-11-07-15-12-06 007" src="https://user-images.githubusercontent.com/80243543/140634678-cf7b8583-693b-40a3-8d40-4be99819deec.png">
<img width="600" alt="스크린샷 2021-11-07 오후 3 30 10" src="https://user-images.githubusercontent.com/80243543/140634910-2ea28c14-bbc2-4a40-aadc-db313ae365c4.png">

마커를 누르면 장소에 대한 설명과 함께 최대 5개의 여행지를 담을 수 있습니다.

<img width="600" alt="스크린샷 2021-11-07 오후 3 30 30" src="https://user-images.githubusercontent.com/80243543/140634948-184efc00-284d-4474-a8d0-afadf3681d9e.png">

여행하기 버튼을 누르면 아래와 같이 자신이 담은 여행지를 동영상으로 감상할 수 있습니다.

<img width="600" alt="스크린샷 2021-11-07 오후 3 30 39" src="https://user-images.githubusercontent.com/80243543/140634983-c1d22819-8814-4554-9d6a-4343c0ba4be0.png">

### 여행 코스 
캐릭터와 지역별 맟춤 여행지를 확인할 수 있습니다.

<img width="600" alt="스크린샷 2021-11-07 오후 3 38 38" src="https://user-images.githubusercontent.com/80243543/140635127-6d250594-10c1-4d75-b0a3-d23029176da1.png">

<img width="600" src="https://user-images.githubusercontent.com/80243543/140635184-03daef08-42e8-4d55-8c06-a9f6adaf5eaa.png">

<img width="600" src="https://user-images.githubusercontent.com/80243543/140635186-cf5ac758-3097-431c-8e8f-a98f09b5724d.png">

### 로그인 

<img width="600" alt="스크린샷 2021-11-07 오후 3 45 23" src="https://user-images.githubusercontent.com/80243543/140635284-e8288416-b820-43e9-93aa-a4c38ebce565.png">
로그인은 구글 로그인을 활용하였고 로그인시 자신의 여행 코스를 기록하고 다시 여행할 수 있는 <나의 여행> 메뉴를 이용할 수 있습니다.

# 사용된 기술 
프론트(html,css,javascripts) + 백엔드 (spring boot)

* spring boot 
* spring security 
* MySql 
* myBatis 
* oAuth2.0 
* AWS 


# Spring boot 

<img width="327" alt="스크린샷 2021-11-07 오후 3 58 23" src="https://user-images.githubusercontent.com/80243543/140635680-5fe40cbe-1a24-4ab0-829b-7d5a65c8a23e.png">

* confing 
* controller 
* domain
* mapper 
* paging
* service

- resource에 mapper.xml을 두어 DB에 접근하였습니다.

# Spring Security
security설정을 추가해서 인가된 사용자만 <나의 여행> 페이지에 접근할 수 있도록 제한했습니다.

* csrf : disable 
* form login : disable 

# oAuth2.0 
oAuth를 이용한 구글 로그인을 통해 회원가입 기능을 간소화하였습니다. 
구글로 부터 사용자의 간단한 정보(이름,이메일)만을 받아 이메일을 통해 사용자 중복 조회를 하고 사용자가 
없는 경우 회원가입을 하고 사용자 정보를 반환하고 있는 경우 저장된 회원 정보를 반환하도록 로직을 구현하였습니다.

<img width="522" alt="스크린샷 2021-11-07 오후 4 10 00" src="https://user-images.githubusercontent.com/80243543/140635922-a555a324-3208-4976-b47e-68d784e56035.png">
