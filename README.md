### 구동방법
#### Docker By Jib
1. ./gradlew jibDockerBuild
2. docker run -p 8080:8080 domino:0.0.1-SNAPSHOT
   * Mac OS M1인 경우 --platform linux/amd64 옵션 추가
3. http://localhost:8080/swagger-ui/ 
   * API Document
4. http://localhost:8080/stock/{stockCode} 
   * 종목코드에 해당하는 종목의 지난 5일 시세데이터 조회
   * KOSPI Only
