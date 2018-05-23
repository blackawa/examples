import React from 'react';
import {hot} from 'react-hot-loader';

const App = () => <div>Hello from react. env is {process.env.NODE_ENV}</div>;
const WrappedApp = process.env.NODE_ENV === 'development' ? hot(module)(App) : App

export default WrappedApp;
