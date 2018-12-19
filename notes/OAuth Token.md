# OAuth Token.md

**OAuth** : 토큰들을 제공하는 방법에 대한 프레임워크 

**JWT** : 토큰의 타입

**Opaque Token** : 토큰소유자가 토큰의 내용을 모르는 토큰



JWT, Opaque 둘 다에서 추천하지 않는 경우

	> - custom claims. Both JWT and opaque OAuth tokens can carry custom claims about the subject.
	> - security. Both are bearer tokens. Both need to be protected as secrets.
	> - expiration. Both can be marked with an expiration. Both can be refreshed.
	> - The authentication mechanism or experience. Both can present the same user experience.

## Opaque Token

- OAuthV2/GenerateAccessToken 정책에서 생성됨.

- 반환 : 32 random characters

- 소유자는 토큰이 무엇을 의미하는지 알지 못 함. (=> 불투명!)

- 토큰을 사용하려면, 토큰 생성자에게 돌려줘야 함.

  - 토큰 생성자만이 해당 토큰의 내용을 알 수 있다.

- 토큰생성자가 보유한 <u>정보에 대한 포인터.</u>

- 사용하는 경우

  >- 토큰생성자 = 토큰 유효성 검사자
  >- 토큰이 있는 모든 API 요청은 토큰 디스펜서를 통과함.
  >- 토큰소유자가 토큰 내의 요청을 검토할 일이 없다.
  >- 토큰 취소를 일방적으로 허용하려는 경우.
  >  - JWT는, 생성 시 표기된 만료시간에 만료되므로, 불가능한 기능이다.

## JWT Token

- 거의 OAuth Bearer token으로 사용됨

- 정보에 대한 포인터 또는 참조가 <u>아님</u>

  - 실제 정보를 가지고 있다.

- 어떤 소유자든 토큰을 열고, 유효성을 검증하고, 인가를 결정할 수 있다.

  > - Federation is desired. For example, you want to use Azure AD as the token issuer, and then use Apigee Edge as the token validator. With JWT, an app can authenticate to Azure AD, receive a token, and then present that token to Apigee Edge to be verified. (Same works with Google Sign-In. Or Paypal. Or [Salesforce.com](http://salesforce.com/). etc)
  > - Asynchrony is required. For example, you want the client to send in a request, and then store that request somewhere, to be acted on by a separate system "later". That separate system will not have a synchronous connection to the client, and it may not have a direct connection to a central token dispensary. a JWT can be read by the asynchronous processing system to determine whether the work item can and should be fulfilled at that later time. This is, in a way, related to the Federation idea above. Be careful here, though: JWT expire. If the queue holding the work item does not get processed within the lifetime of the JWT, then the claims should no longer be trusted.

