let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim();
let number = parseInt(input, 10);

function solution(number) {
    if (number < 100)
        return number
    else {
        let count = 99;
        for (let i = 100; i <= input; i++) {
            let arr = i.toString().split('').map(Number);
            if (arr[0] - arr[1] === arr[1] - arr[2])
                count++;
        }
        return count;
    }
}

console.log(solution(number));