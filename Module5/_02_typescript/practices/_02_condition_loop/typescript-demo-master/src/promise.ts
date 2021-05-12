import './scss/styles.scss';

const wait5Secs = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve(5);
  }, 5000);
});

wait5Secs.then(data => console.log(data)).catch(err => console.error(err));

function httpGet(url: string): Promise<any> {
  return new Promise(function(resolve, reject) {
    const request = new XMLHttpRequest();
    request.onload = function() {
      if (this.status === 200) {
        // Success
        resolve(this.response);
      } else {
        // Something went wrong (404 etc.)
        reject(new Error(this.statusText));
      }
    };
    request.onerror = function() {
      reject(new Error('XMLHttpRequest Error: ' + this.statusText));
    };
    request.open('GET', url);
    request.send();
  });
}
httpGet('https://api.github.com/search/repositories?q=angular').then(
  function(value) {
    console.log('Contents: ' + value);
  },
  function(reason) {
    console.error('Something went wrong', reason);
  }
);
// parseJSON
function parseResponse(value: string) {
  try {
    return JSON.parse(value);
  } catch (_) {
    return value;
  }
}
httpGet('https://api.github.com/search/repositories?q=angular')
  .then(parseResponse)
  .then(data => console.log(data))
  .catch(function(reason) {
    console.error('Something went wrong', reason);
  });

// promise chỉ resolve hoặc reject duy nhất 1 lần
const promise = new Promise((resolve, reject) => {
  resolve('done');
  reject(new Error('…')); // ignored
  setTimeout(() => resolve('…')); // ignored
});

promise.then(data => console.log(data));

/**
 * Async/Await
 */
async function f() {
  return 1;
}

function fp() {
  return Promise.resolve(1);
}

f().then(data => console.log('async fn', data));

(async() => {
  const data = await fp();
  console.log('async/await', data);
})();

async function fns() {
  const promise = new Promise((resolve, reject) => {
    setTimeout(() => resolve("done!"), 1000)
  });
  // wait till the promise resolves (*)
  const result = await promise;
  console.log(result); // "done!"
}
fns();

// handle error
async function getUser(username: string) {
  try {
    const response = await fetch(
    `https://api.github.com/search/users?q=${username}`
    );
    return await response.json();
  } catch (e) {
    throw e;
  }
}
getUser('bob')
  .then(res => console.log(res))
  .catch(err => console.warn(err));


// do not combine sync operations with async/await
(() => {
  let x = 0;
  async function r5() {
    x += 1;
    console.log(x);
    return 5;
  }
  (async () => {
    x += await r5();
    console.log(x);
  })();
})();

// fixed version
(() => {
  let x = 0;
  async function r5() {
    x += 1;
    console.log(x);
    return 5;
  }
  (async () => {
    const y = await r5();
    x += y;
    console.log(x);
  })();
})();

// Too Sequential
async function fetchAllBook() {
  await new Promise(resolve => {
    console.log('Waiting 2s...');
    setTimeout(() => resolve(), 2000);
  });
  console.log('fetchAllBook');
  return [
    {
      id: 'book-id-1',
      authorId: 'author-id-1'
    }, {
      id: 'book-id-2',
      authorId: 'author-id-2'
    }, {
      id: 'book-id-3',
      authorId: 'author-id-3'
    }
  ];
}

async function fetchAuthorById(authorId: string) {
  console.log('fetchAuthorById');
  return {
    authorId,
  };
}
async function getBooksAndAuthor(authorId: string) {
  const books = await fetchAllBook();
  const author = await fetchAuthorById(authorId);
  return {
    author,
    books: books.filter(book => book.authorId === authorId),
  };
}

getBooksAndAuthor('author-id-2');

// Too Sequential fixed
async function getBooksAndAuthorFixed(authorId: string) {
  const bookPromise = fetchAllBook();
  const authorPromise = fetchAuthorById(authorId);
  const books = await bookPromise;
  const author = await authorPromise;
  return {
    author,
    books: books.filter(book => book.authorId === authorId),
  };
}

getBooksAndAuthorFixed('author-id-2');

