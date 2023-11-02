'use strict';

function updateLocalData() {
  let ds = [];
  document.querySelectorAll('.qr-img').forEach(i => ds.push(i.chl));
  localStorage.setItem('_local_qr_codes_', JSON.stringify(ds.map(i => i)));
}

function generate32BitTimestamp() {
  const timestamp = new Date().getTime(); // 获取当前时间戳
  const timestamp32Bit = timestamp.toString(32); // 转换为 32 位的字符串
  return timestamp32Bit;
}

function bindImage(img, chl) {
  img.chl = chl;
  img.innerHTML = '';
  let qr = new QRCode(img, {
    width: 360,
    height: 360,
    useSvg: true,
    correctLevel: QRCode.CorrectLevel.L
  });
  console.log(chl);
  let qrCodeId = generate32BitTimestamp();
  if (chl !== "hello, world") {
    // send(qrCodeId, chl);
    fetchPost(qrCodeId, chl);
  }
  qr.makeCode('http://10.15.10.9:8080/code/' + qrCodeId);

}

function createQR(chl) {
  let container = document.createElement('div');
  container.className = 'qr-container';
  let input = document.getElementById('mytextarea');
  let qrImg = document.createElement('div');
  qrImg.className = 'qr-img';
  if (chl) {
    bindImage(qrImg, chl);
    input.value = chl;
  }
  qrImg.addEventListener('click', function (e) {
    if (e.altKey) {
      e.preventDefault()
      e.stopPropagation()
      container.parentNode.removeChild(container);
      updateLocalData();
    }
  });


  container.appendChild(qrImg);

  return container;
}

function parseQrFromQuery() {
  const query = new URLSearchParams(location.search);
  let qrs = query.get('qrs');
  try {
    return JSON.parse(qrs);
  } catch (e) {
    console.error(e);
  }
  return null;
}

function clearSearch() {
  location.href = location.href.substr(0, location.href.length - location.search.length);
}

function init() {
  let content = document.querySelector('div.content');
  let add = document.createElement('button');
  add.className = 'qr-add';
  add.textContent = '二维码生成器';
  add.addEventListener('click', () => {
    bindImage(document.querySelector("div.qr-img"), document.getElementById('mytextarea_ifr').contentDocument.documentElement.innerHTML);
  });

  content.appendChild(add);
  let localQr = JSON.parse('["hello, world"]');
  let queryQr = parseQrFromQuery();
  console.log(localQr);
  localQr.forEach(chl => content.insertBefore(createQR(chl), add));
  if (queryQr) {
    queryQr.filter(q => !localQr.find(i => i === q)).forEach(chl => content.insertBefore(createQR(chl), add));
    updateLocalData();
    setTimeout(clearSearch, 300);
  }
}

init();


function send(qrCodeId, content) {
  const url = 'http://localhost:8080/code'; // 请将其替换为您的基本 URL
  const data = { qrCodeId: qrCodeId, content: content}; // 要附加的数据

  const xhr = new XMLHttpRequest();
  xhr.open('POST', url, true);
  xhr.setRequestHeader('Content-Type', 'application/json');

  xhr.onload = function () {
    if (xhr.status >= 200 && xhr.status < 300) {
      console.log('请求成功', xhr.responseText);
    } else {
      console.log('请求失败', xhr.statusText);
    }
  };

  xhr.onerror = function () {
    console.error('请求错误');
  };

  xhr.send(JSON.stringify(data));
}

function fetchPost(qrCodeId, content) {
  const url = '/code'; // 将其替换为您要发送 POST 请求的 URL
  const data = {qrCodeId: qrCodeId, content: content}; // 要发送的 JSON 数据

  fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data) // 将 JSON 数据作为字符串发送
  })
      .then(response => {
        if (!response.ok) {
          throw new Error('请求失败');
        }
        return response.json();
      })
      .then(data => {
        console.log('请求成功', data);
      })
      .catch(error => {
        console.error('请求错误', error);
      });

}
