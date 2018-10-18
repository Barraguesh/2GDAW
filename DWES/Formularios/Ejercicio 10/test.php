<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
    <?php 
        if(isset($_GET["mb"])) {
            echo $_GET["mb"]," mb son ", $_GET["mb"] * 1000," kb.";
        }
    ?>
</body>
</html>