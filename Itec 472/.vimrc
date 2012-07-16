syntax on
filetype plugin on 
filetype plugin indent on

set modeline

set number
noremap <F2> :set nonumber!<CR>:set foldcolumn=0<CR>

set pastetoggle=<F3>
set showmode
noremap  :set invpaste paste?<CR>

au FileType python setlocal tabstop=8 expandtab shiftwidth=4 softtabstop=4

set ruler
set backspace=2
set autoindent
set showcmd
set nowrap

noremap ; :
inoremap jj <Esc>


noremap <F4> <Esc>:tabe
noremap <F5> :split<CR>
noremap <F6> :vsplit<CR>
noremap <F7> <C-w><C-w>
