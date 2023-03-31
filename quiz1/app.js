const quiz = [
    {
      question: '日本の首都はどこでしょうか？',
      answers: [
        '東京都',
        '京都府',
        '大阪府',
        '北海道'
      ],
      correct: '東京都'
    }, {
      question: '次のうち、果物でないものはどれでしょうか？',
      answers: [
        'バナナ',
        'りんご',
        'キウイ',
        'トマト'
      ],
      correct: 'トマト'
    }, {
      question: '世界遺産に登録されている「平泉」はどこの地域にありますか？',
      answers: [
        '京都',
        '北海道',
        '岩手県',
        '沖縄県'
      ],
      correct: '岩手県'
    }
];

const quizLength = quiz.length;
let quizIndex = 0;
let score = 0;

const $button = document.getElementsByTagName('button');
const buttonLength = $button.length;

const setupQuiz = () => {
    document.getElementById('js-question').textContent = quiz[quizIndex].question;
    let buttonIndex = 0;
    while(buttonIndex < buttonLength){
        $button[buttonIndex].textContent = quiz[quizIndex].answers[buttonIndex];
        buttonIndex++;
    }
}

setupQuiz();

const clickHandler = (e) => {
    if(quiz[quizIndex].correct == e.target.textContent){
        window.alert('正解!');
        score++;
    } else {
        window.alert('不正解!');
    }
    quizIndex++;

    if(quizIndex < quizLength){
        setupQuiz();
    } else {
        window.alert('終了!あなたの正解数は' + score + '/' + quizLength + 'です!');
    }
}

let handlerIndex = 0;
while(handlerIndex < buttonLength){
    $button[handlerIndex].addEventListener('click', (e) => {
        clickHandler(e);
    });
    handlerIndex++;
}
