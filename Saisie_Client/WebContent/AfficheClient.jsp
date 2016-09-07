<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="ls"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste de vos clients</title>
</head>
<body>
	<table align=center border=1 cellpadding=5>
		<tr>
			<td align="center" colspan=10>
				<h1>Affichage client</h1>
			</td>
		</tr>

		<ls:forEach items="${clientBeans}" var="bean">
			<tr>
				<td>Nom</td>
				<td>${bean.nom}</td>
				<td>prénom</td>
				<td>${bean.prenom}</td>
				<td>Téléphone</td>
				<td>${bean.tel}</td>
				<td>email</td>
				<td>${bean.email}</td>
			</tr>
			</ls:forEach>

			<input name="ecran" value="saisie" type="hidden">
			<tr>
				<td align="center" colspan=10>
					<form method="get" action="Main">
						<input name="bouton" type="submit" value="Retour">
					</form>
				</td>
			</tr>
	</table>
</body>
</html>