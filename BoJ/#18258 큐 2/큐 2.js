let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const n = input.shift();
const queue = [];
function solution() {
    const answer = [];
    let idx = 0;
    for (let i = 0; i < n; i++) {
        let command = input[i].split(' ');
        let temp;

        switch (command[0]) {
            case 'push':
                queue.push(command[1]);
                break;
            case 'pop':
                if (idx >= queue.length)
                    answer.push(-1);
                else {
                    answer.push(queue[idx]);
                    idx++;
                }
                break;
            case 'size':
                answer.push(queue.length - idx);
                break;
            case 'empty':
                if (idx >= queue.length)
                    answer.push(1);
                else
                    answer.push(0);
                break;
            case 'front':
                if (idx >= queue.length)
                    answer.push(-1);
                else
                    answer.push(queue[idx]);
                break;
            case 'back':
                if (idx >= queue.length)
                    answer.push(-1);
                else
                    answer.push(queue[queue.length - 1]);
                break;
        }
    }
    return answer.join("\n");
}

console.log(solution());