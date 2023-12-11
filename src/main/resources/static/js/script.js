let stompClient = null;

console.log("hello, stomp!");

let socket;

const connectBtn = document.getElementById("connect-btn");
connectBtn.addEventListener('click', () => {
    const urlInput = document.getElementById("websocket_url");
    socket = new SockJS(urlInput.value);
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        document.getElementById("connected").innerText = "Connected";
    }, function(error) {
        console.log('Connection error: ' + error);
        document.getElementById("connected").innerText = "Connection Failed";
    });
});

function showMessage(message) {
    const response = document.getElementById('response');
    response.innerHTML += '<p>' + message + '</p>';
}

// sendMessage 함수를 사용합니다.
function sendMessage() {
    const sendUrl = document.getElementById("send-url").value.trim();
    const sendContent = document.getElementById('send-body').value.trim()
    if(sendContent && stompClient) {
        // const message = { content: sendContent };
        stompClient.send(sendUrl, {}, sendContent);
    } else if (stompClient) {
        stompClient.send(sendUrl);
    }

}

const sendBtn = document.getElementById("send-btn");
// sendBtn 이벤트 핸들러를 수정합니다.
sendBtn.addEventListener('click', sendMessage);

const subscribeBtn = document.getElementById("subscribe-btn")

subscribeBtn.addEventListener('click', () => {
    const subscribeUrl = document.getElementById("subscribe-url").value;

    if (subscribeUrl) {
        stompClient.subscribe(subscribeUrl, function(message) {
            console.log("메세지 받아짐!");
            console.log(message);
            showMessage(message.body);
        });

        // 구독 리스트에 추가
        const subscribeList = document.getElementById("subscirbe-list");
        const listItem = document.createElement("li");
        listItem.textContent = subscribeUrl;
        subscribeList.appendChild(listItem);
    }
})



