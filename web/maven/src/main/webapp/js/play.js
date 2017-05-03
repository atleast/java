/**
 * Created by deli on 03/05/2017.
 */
var stoneFlag=false;
var headFlag=false;
var qrFlag=false;
var stoneNum=3;
var headNum=5;
var qrNum=7;
var sum=stoneNum+headNum+qrNum;
function layout(divName, num) {
    var parentNode=document.getElementById(divName);
    for(i=0;i<num;i++) {
        var childNode=document.createElement("input");
        childNode.type = "image";
        childNode.id = divName+i;
        childNode.src = "images/"+divName+".png";
        childNode.width = "50";
        childNode.height = "50";
        childNode.setAttribute("onclick","removeStone('"+divName+"','"+divName+i+"')");
        parentNode.appendChild(childNode);
    }
}
function removeStone(divName,stoneID) {
    if(!(stoneFlag||headFlag||qrFlag)) {
        switch (divName) {
            case "stone":
                stoneFlag = true;
                break;
            case "head":
                headFlag = true;
                break;
            case "qr":
                qrFlag = true;
                break;

        }
    }
    switch (divName){
        case "stone":
            judgeStatus(stoneFlag,divName,stoneID);
            checkFinalResult();
            break;
        case "head":
            judgeStatus(headFlag,divName,stoneID);
            checkFinalResult();
            break;
        case "qr":
            judgeStatus(qrFlag,divName,stoneID);
            checkFinalResult();
            break;
    }
}
function judgeStatus(flag,divName,stoneID) {
    if(flag){
        var parentNode=document.getElementById(divName);
        parentNode.removeChild(document.getElementById(stoneID));
        sum--;
    }else{
        alert("NOT ALLOWED!!!");
    }
}
function turnOver() {
    stoneFlag=false;
    headFlag=false;
    qrFlag=false;
}
function checkFinalResult() {
    if(sum==1){
        alert("Congratulations! You Win!");
    }
}