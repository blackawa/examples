// RESTでいうリソース単位でmoduleに分割する
export default {
  state: {
    items: [
      {
        id: 0,
        done: true,
        title: 'Vue入門する'
      },
      {
        id: 1,
        done: false,
        title: 'Vuex入門する'
      },
    ],
  },
  // CRUDのうちR以外を用意しておく
  mutations: {
    create: (state, item) => state.items.push(Object.assign({}, item, {id: state.items.length})),
    update: (state, item) => state.items = state.items.map(i => i.id === item.id ? item : i),
    delete: (state, id) => state.items = state.items.filter(item => item.id !== id),
  },
  getters: {
    doneTodoCount: state => state.items.filter(item => item.done).length
  }
}