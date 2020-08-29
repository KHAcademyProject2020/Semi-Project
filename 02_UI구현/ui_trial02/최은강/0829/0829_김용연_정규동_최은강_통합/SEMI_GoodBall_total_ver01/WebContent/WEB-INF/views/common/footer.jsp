<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
<script src="https://kit.fontawesome.com/09697e2134.js" corssorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/WebContent/resources/css/footer.css" type="text/css"> --%>

<style>
:root { 
	--footer-background: #272929; 
	--footer-text-color: #e9faec;
}

footer {
	position: absolute;
	min-height: calc(100vh -245px);
	display: flex;
	flex-direction: row;
	align-items: baseline;
	justify-content: space-around;
/* 	bottom: 0; */
	width: 100%;
	background: var(--footer-background);
	color: var(--footer-text-color);
	text-align: center;
}

footer ul.company-info a{
	text-decoration: none !important;
	color: var(--footer-text-color);
}

footer ul.company-info {
	list-style: none;
	font-size: 1.6em;
	display: flex;
	flex-direction: row;
	align-items: baseline;
	justify-content: space-around;
}

footer ul.company-info>li {
	padding: 12px 30px;
}

/*media query */
@media screen and (max-width: 768 px) {
	/*화면의 폭길이가 768px 이하이면 */
	footer, footer ul.company-info {
		box-sizing: content-box;
		flex-direction: column;
		flex-wrap: wrap;
	}
	ul.company-info li {
		font-size: 1.2em;
		align-items: flex-start;
		justify-content: center;
	}
}
</style>
</head>


<body>
	<div class="footer-contaienr">
		<footer>
			<ul class="company-info">
				<li><i class="fas fa-phone-alt"></i></li>
				<li><i class="fas fa-futbol"></i> Good Ball</li>
				<li><a href="https://github.com/KHAcademyProject2020/Semi-Project"><i class="fab fa-github"></i></a></li>
			</ul>
		</footer>
	</div>

</body>
</html>