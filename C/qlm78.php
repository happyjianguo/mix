<?php
$string = <<<XML
<?xml version='1.0'?>
<document>
    <name>Sayalic</name>
    <age>25</age>
    <girlfriend>null</girlfriend>
    <gayfriend>
        <age>24.5</age>
        <name>dploop</name>
        <FavoriteFruits>pear</FavoriteFruits>
        <FavoriteFruits>lemon</FavoriteFruits>
    </gayfriend>
    <FavoriteFruits>orange</FavoriteFruits>
    <FavoriteFruits>banana</FavoriteFruits>
    <FavoriteFruits>apple</FavoriteFruits>
</document>
XML;

$xml = simplexml_load_string($string);
var_dump($xml);
if(is_object($xml))
{
    foreach($xml->entry as $photo)
    {
        echo $photo->content;
    }
}

$json = json_encode($xml,JSON_UNESCAPED_UNICODE);
print_r($json);