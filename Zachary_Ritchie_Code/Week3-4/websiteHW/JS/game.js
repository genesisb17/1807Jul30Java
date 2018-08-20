window.onload = function()
{
    document.getElementById("q1compute").addEventListener("click", pdt, true);
    document.getElementById("q2compute").addEventListener("click", nt, true);
    document.getElementById("q3compute").addEventListener("click", it, true);
    document.getElementById("q4compute").addEventListener("click", fpt, true);
}

function pdt()
{
    var a = document.getElementById("boolean1").checked;
    var b = document.getElementById("byte1").checked;
    var c = document.getElementById("char1").checked;
    var d = document.getElementById("double1").checked;
    var e = document.getElementById("float1").checked;
    var f = document.getElementById("int1").checked;
    var g = document.getElementById("long1").checked;
    var h = document.getElementById("short1").checked;
    if(a && b && c && d && e && f && g && h)
    {
        document.getElementById("q1").style  = "color:green;";
        document.getElementById("q1").innerHTML = "Correct";
    }
    else
    {
        document.getElementById("q1").style  = "color:red;";
        document.getElementById("q1").innerHTML = "Incorrect";
    }
}

function nt()
{
    var a = document.getElementById("boolean2").checked;
    var b = document.getElementById("byte2").checked;
    var c = document.getElementById("char2").checked;
    var d = document.getElementById("double2").checked;
    var e = document.getElementById("float2").checked;
    var f = document.getElementById("int2").checked;
    var g = document.getElementById("long2").checked;
    var h = document.getElementById("short2").checked;
    if((a == false) && b && c && d && e && f && g && h)
    {
        document.getElementById("q2").style  = "color:green;";
        document.getElementById("q2").innerHTML = "Correct";
    }
    else
    {
        document.getElementById("q2").style  = "color:red;";
        document.getElementById("q2").innerHTML = "Incorrect";
    }
}

function it()
{
    var a = document.getElementById("boolean3").checked;
    var b = document.getElementById("byte3").checked;
    var c = document.getElementById("char3").checked;
    var d = document.getElementById("double3").checked;
    var e = document.getElementById("float3").checked;
    var f = document.getElementById("int3").checked;
    var g = document.getElementById("long3").checked;
    var h = document.getElementById("short3").checked;
    if((a == false) && b && c && (d == false) && (e == false) && f && g && h)
    {
        document.getElementById("q3").style  = "color:green;";
        document.getElementById("q3").innerHTML = "Correct";
    }
    else
    {
        document.getElementById("q3").style  = "color:red;";
        document.getElementById("q3").innerHTML = "Incorrect";
    }
}

function fpt()
{
    var a = document.getElementById("boolean4").checked;
    var b = document.getElementById("byte4").checked;
    var c = document.getElementById("char4").checked;
    var d = document.getElementById("double4").checked;
    var e = document.getElementById("float4").checked;
    var f = document.getElementById("int4").checked;
    var g = document.getElementById("long4").checked;
    var h = document.getElementById("short4").checked;
    var i = true;
    var j = false
    if((a == false) && (b == false) && (c == false) && d && e && (f == false) && (g == false) && (h == false))
    {
        document.getElementById("q4").style  = "color:green;";
        document.getElementById("q4").innerHTML = "Correct";
    }
    else
    {
        document.getElementById("q4").style  = "color:red;";
        document.getElementById("q4").innerHTML = "Incorrect";
    }
}