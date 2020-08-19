<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('/res/images/gg.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-49"> Sign Up </span>

					<div class="wrap-input100 validate-input m-b-23"
						data-validate="ID is reauired">
						<span class="label-input100">ID</span> <input
							class="input100" type="text" name="ui_id" id="ui_id"
							placeholder="Type your ID"> <span class="focus-input100"
							data-symbol="&#x270C;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">Password</span> <input
							class="input100" type="password" name="ui_password" id="ui_pwd"
							placeholder="Type your password"> <span
							class="focus-input100" data-symbol="&#xf190;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Name is reauired">
						<span class="label-input100">Name</span> <input
							class="input100" type="text" name="ui_name" id="ui_name"
							placeholder="Type your Name"> <span class="focus-input100"
							data-symbol="&#x263A;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Age is reauired">
						<span class="label-input100">Age</span> <input
							class="input100" type="text" name="ui_age" id="ui_age"
							placeholder="Type your Age"> <span class="focus-input100"
							data-symbol="&#x2764;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Birth is reauired">
						<span class="label-input100">Birth</span> <input
							class="input100" type="date" name="ui_birth" id="ui_birth"
							placeholder="Type your Birth"> <span class="focus-input100"
							data-symbol="&#x263C;"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Phone is reauired">
						<span class="label-input100">Phone</span> <input
							class="input100" type="text" name="ui_phone" id="ui_phone"
							placeholder="Type your Phone"> <span class="focus-input100"
							data-symbol="&#x260E;"></span>
					</div>


					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Email is reauired">
						<span class="label-input100">Email</span> <input
							class="input100" type="text" name="ui_email" id="ui_email"
							placeholder="Type your Email"> <span class="focus-input100"
							data-symbol="&#x40;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23"
						data-validate="Nickname is reauired">
						<span class="label-input100">Nickname</span> <input
							class="input100" type="text" name="ui_nickname" id="ui_nickname"
							placeholder="Type your Nickname"> <span class="focus-input100"
							data-symbol="&#x266B;"></span>
					</div>



					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type="button" class="login100-form-btn"
								onclick="doLogin()">Sign Up</button>
						</div>
					</div>

					
				</form>
			</div>
		</div>
	</div>

</body>
</html>