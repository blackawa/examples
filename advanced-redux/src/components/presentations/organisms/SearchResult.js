import React from 'react';

const borderColor = '#aaa';

const tableCellStyle = {
  fontSize: '.9rem',
  border: `solid 1px ${borderColor}`,
  padding: '0.25rem',
};

const TableCell = ({children}) => <td style={tableCellStyle}>{children}</td>;

const TableHeaderCell = ({children}) => <th style={tableCellStyle}>{children}</th>;

const SearchResult = ({repositories}) => {
  const repositoryRows = repositories && repositories.items ? repositories.items.map(item => <tr>
    <TableCell>{item.name}</TableCell>
    <TableCell>{item.url}</TableCell>
  </tr>) : null;

  const style = {border: `solid 1px ${borderColor}`, borderCollapse: 'collapse'};

  return <table style={style}>
    <thead>
    <tr>
      <TableHeaderCell>Name</TableHeaderCell>
      <TableHeaderCell>URL</TableHeaderCell>
    </tr>
    </thead>
    <tbody>
    {repositoryRows}
    </tbody>
  </table>
};

export default SearchResult