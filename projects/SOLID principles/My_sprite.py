import os
os.environ['PYGAME_HIDE_SUPPORT_PROMPT'] = "hide"
import pygame

class My_sprite:
    def __init__(self, image_file_name:str, location:tuple[int, int]=(0,0)):
        self.image_file_name = image_file_name
        self.location = location
        self.image = pygame.image.load(image_file_name)
        self.width = self.image.get_width()
        self.height = self.image.get_height()
        
    def get_image (self):
        return self.image
    
    def get_width(self):
        return self.width
    
    def get_height(self):
        return self.height