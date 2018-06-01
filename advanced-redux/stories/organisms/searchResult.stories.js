import React from 'react';
import {storiesOf} from '@storybook/react';
import SearchResult from '../../src/components/presentations/organisms/SearchResult';

storiesOf('organisms/SearchResult', module)
    .add('default', () => <SearchResult repositories={[{name: 'babel', url: 'https://github.com/babel/babel'}, {name: 'babel-loader', url: 'https://github.com/babel/babel-loader'}]}/>)
    .add('empty', () => <SearchResult/>);