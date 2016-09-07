<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>écran de saisie client</title>
</head>
<body>
	<form method="get" action="Main">
		<table align=center border=1 cellpadding=5>
			<tr>
				<td align="center" colspan=10>
					<h1>Saisie d'un nouveau client</h1>
					<input name="ecran" value="saisie" type="hidden">
			<tr>

				<td>Nom</td>
				<td><input name="nom" type="text" size="25" value="${bean.nom}">
				</td>
				<td>prénom</td>
				<td><input name="prenom" type="text" size="25"
					value="${bean.prenom}"></td>
			</tr>
			<tr>
				<td>Téléphone</td>
				<td><input name="tel" type="text" size="25" value="${bean.tel}">
				</td>
				<td>email</td>
				<td><input name="email" type="text" size="25"
					value="${bean.mail}"></td>
			</tr>
			<tr>
				<td>mot de passe</td>
				<td><input name="pwd" type="password" size="25" value="${bean.pwd}">
				</td>
	
				
			</tr>
			<tr>
				<td align="center" colspan=10>${bean.erreur1}<br><input name="bouton"
					type="submit" value="Valider"></td>
			</tr>

		</table>
	</form>
</body>
</html>